package com.lvfq.library.utils;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lvfq.library.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * LvDownloadDialog
 *
 * @author lvfq
 * @Github: https://github.com/lvfaqiang
 * @Blog: http://blog.csdn.net/lv_fq
 * @date 2017/8/31 上午8:48
 * @desc :
 */

public class LvDownloadDialog extends AlertDialog implements View.OnClickListener {

    /* 下载中 */
    private static final int DOWNLOAD = 1;
    /* 下载结束 */
    private static final int DOWNLOAD_FINISH = 2;

    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_cancel;
    private TextView tv_confirm;
    private ProgressBar pb_dialog_download_progress;
    private LinearLayout ll_dialog_download_bottom;
    private View tv_dialog_down_line_bottom_hor;
    private View tv_dialog_down_line_bottom_ver;

    private String mSavePath = "";  // 下载路径
    private String apkName = System.currentTimeMillis() + ".apk";   // 安装包名称
    private String downlaodPath = "";   // 下载路径
    private int progress = 0;   // 下载进度
    private float scale = 0.75f;    // dialog 占屏幕的宽度比
    private ValueAnimator valueAnimator;

    private boolean isMustUpdate = false;   // 是否强制更新
    private boolean cancelUpdate = false;   // 是否取消下载
    private boolean isDownloading = false;  // 是否正在下载


    private Context context;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                // 正在下载
                case DOWNLOAD:
                    // 设置进度条位置
                    pb_dialog_download_progress.setProgress(progress);
                    break;
                case DOWNLOAD_FINISH:
                    // 安装文件
                    installApk();
                    break;
                default:
                    break;
            }
        }

        ;
    };

    /**
     * 设置下载的 apk文件名
     *
     * @param apkName
     */
    public void setApkName(String apkName) {
        if (LvEmptyUtil.isEmpty(apkName)) {
            throw new NullPointerException("download apkName is null");
        }
        this.apkName = apkName;
    }

    /**
     * 设置宽度比
     *
     * @param scale
     */
    public void setScale(float scale) {
        if (scale >= 0) {
            this.scale = scale;
        }
    }

    /**
     * 设置是否强制更新
     *
     * @param mustUpdate
     */
    public void setMustUpdate(boolean mustUpdate) {
        isMustUpdate = mustUpdate;
    }

    /**
     * 初始化
     *
     * @param context
     * @param downlaodUrl 下载地址
     * @param apkName      安装包名称
     * @param isMustUpdate 是否强制更新
     * @param scale        宽度比
     */
    public LvDownloadDialog(Context context, String downlaodUrl, String apkName, boolean isMustUpdate, float scale) {
        super(context);
        this.context = context;
        this.isMustUpdate = isMustUpdate;

        if (LvEmptyUtil.isEmpty(downlaodPath)) {
            throw new RuntimeException("downloadPath can't is null");
        } else {
            this.downlaodPath = downlaodUrl;
        }

        if (LvEmptyUtil.isNotEmpty(apkName)) {
            this.apkName = apkName;
        }
        if (scale != 0) {
            this.scale = scale;
        }
    }

    /**
     * @param context
     * @param downlaodUrl 下载路径
     * @param apkName      安装包名称
     */
    public LvDownloadDialog(Context context, String downlaodUrl, String apkName) {
        this(context, downlaodUrl, apkName, false, 0);
    }

    /**
     * @param context
     * @param downlaodUrl 下载路径
     */
    public LvDownloadDialog(Context context, String downlaodUrl) {
        this(context, downlaodUrl, "", false, 0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_download);

        init();

        setCancelable(false);
        setCanceledOnTouchOutside(false);

        // 设置Dialog显示的宽度，
        Display d = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        //这里设置为屏幕宽度的百分之八十
        lp.width = (int) (d.getWidth() * scale);
        getWindow().setAttributes(lp);

    }

    private void init() {
        tv_title = f(R.id.tv_dialog_download_title);
        tv_content = f(R.id.tv_dialog_download_content);
        tv_cancel = f(R.id.tv_dialog_download_cancel);
        tv_confirm = f(R.id.tv_dialog_download_confirm);
        pb_dialog_download_progress = f(R.id.pb_dialog_download_progress);
        ll_dialog_download_bottom = f(R.id.ll_dialog_download_bottom);

        tv_dialog_down_line_bottom_hor = f(R.id.tv_dialog_down_line_bottom_hor);
        tv_dialog_down_line_bottom_ver = f(R.id.tv_dialog_down_line_bottom_ver);

        tv_confirm.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
    }


    /**
     * 简化实例化代码
     *
     * @param resId
     * @param <T>
     * @return
     */
    private <T extends View> T f(int resId) {
        return LvV.find(this, resId);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_dialog_download_cancel) {
            if (isMustUpdate) {
                LvAppManager.getAppManager().AppExit();
            }
            dismiss();
        }
        if (id == R.id.tv_dialog_download_confirm) {
            startDownload();
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (valueAnimator != null && valueAnimator.isStarted()) {
            valueAnimator.end();
        }
    }

    /**
     * 开始下载
     */
    private void startDownload() {
        new DownloadApkThread().start();
        tv_content.setVisibility(View.GONE);
        pb_dialog_download_progress.setVisibility(View.VISIBLE);
        ll_dialog_download_bottom.setVisibility(View.GONE);
        tv_dialog_down_line_bottom_hor.setVisibility(View.GONE);

        final String[] scoreText = {".  ", ".. ", "..."};
        valueAnimator = ValueAnimator.ofInt(0, 3).setDuration(1000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);   // 设置一直循环
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int pos = (int) animation.getAnimatedValue();
                tv_title.setText("正在更新" + scoreText[pos % scoreText.length]);
            }
        });
        valueAnimator.start();
    }


    /**
     * 安装APK文件
     */
    private void installApk() {

        File apkfile = new File(mSavePath, apkName);
        if (!apkfile.exists()) {
            return;
        }
        // 通过Intent安装APK文件
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + apkfile.toString()),
                "application/vnd.android.package-archive");
        /** 清空用户的缓存 **/
//        SpUtil.clear(UpdateCodeActivity.this);
        context.startActivity(i);
        // 取消下载对话框显示
        dismiss();
        android.os.Process.killProcess(android.os.Process.myPid()); // kill 当前应用
    }


    /**
     * 下载文件线程
     *
     * @author coolszy
     * @date 2012-4-26
     * @blog http://blog.92coding.com
     */
    private class DownloadApkThread extends Thread {
        @Override
        public void run() {
            try {
                // 判断SD卡是否存在，并且是否具有读写权限
                if (Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)) {
                    // 获得存储卡的路径
                    String sdpath = Environment.getExternalStorageDirectory()
                            + "/";
                    mSavePath = sdpath + "download";

                    URL url = new URL(downlaodPath);
                    // 创建连接
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    conn.connect();
                    // 获取文件大小
                    int length = conn.getContentLength();
                    // 创建输入流
                    InputStream is = conn.getInputStream();

                    File file = new File(mSavePath);
                    // 判断文件目录是否存在
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File apkFile = new File(mSavePath, apkName);
                    FileOutputStream fos = new FileOutputStream(apkFile);
                    int count = 0;
                    // 缓存
                    byte buf[] = new byte[1024];
                    // 写入到文件中
                    do {
                        int numread = is.read(buf);
                        count += numread;
                        // 计算进度条位置
                        progress = (int) (((float) count / length) * 100);
                        // 更新进度
                        mHandler.sendEmptyMessage(DOWNLOAD);
                        if (numread <= 0) {
                            // 下载完成
                            mHandler.sendEmptyMessage(DOWNLOAD_FINISH);
                            break;
                        }
                        // 写入文件
                        fos.write(buf, 0, numread);
                    } while (!cancelUpdate);// 点击取消就停止下载.
                    fos.close();
                    is.close();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
