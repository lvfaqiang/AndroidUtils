# AndroidUtils - 功能清单
#### 添加 MultiDex 包（根据需要）

    添加依赖（compile）implementation 'com.android.support:multidex:1.0.2'
    继承 MultiDexApplication()

## 资源文件清单(values)
[dimens.xml](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/res/values/dimens.xml) - 尺寸单位

    dp - [1-375] 
    px - [1-375]
    sp - [1-50 ]  
    
[colors.xml](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/res/values/colors.xml) - 整理了几个项目所用的颜色值（c_xxxxxx : 表示 完整颜色值 , color_ab : 表示 ababab 类型颜色值）

## 工具类列表：
### A
[AndroidUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/AndroidUtil.java) - Android设备工具类(获取设备号，安装 Apk, 是否安装了某应用..)

    getAndroidId() - 获取当前设备唯一标识
    installApk     - 安装 Apk 文件
    isInstallApp   - 是否安装了某应用
[AppManager.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/AppManager.java) - 项目中的 Activity 管理类

    在BaseActivity 中使用:
        onCreate() 中添加： AppManager.getAppManager().addActivity(this);
        onDestroy()中添加： AppManager.getAppManager().finishActivity(this);
    可通过调用 AppManager.getAppManager().getActivityStack（）获取保存当前所有 Activity 的栈。
    退出应用 
        AppExit(boolean); - 可选择是否 kill 掉
[AppUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/AppManager.java) - 应用相关工具类（获取版本号，对比版本，名称，图标等）

    callPhoneAuto(String)          - 拨打电话（直接呼叫）
    callPhone(String)              - 调至拨号界面，需要手动点击呼叫
    compareVersion(String ,String) - 对比两个版本号的大小
    getVersionName()               - 获取当前应用版本号
    getAppIcon()                   - 获取当前应用图标 Id
    getAppName()                   - 获取当前应用名称
    isAppRunningForeground()       - 当前 App 是否运行在前台
    isServiceRunning(String)       - 判断某个服务是否在运行
    startToCamera(...)             - 唤起系统相机，进行拍照。并且返回照片路径
### B
[BottomPopwin.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/BottomPopwin.java) - 底部弹出框工具类

    BottomPopwin popupWindow = new BottomPopwin(context, layoutId);
    View view = popupWindow.getContentView();
    
    //... 实例化相关操作 TextView tv = LvV.find(view , id);
    
    popupWindow.setCancelable(true);
    popupWindow.show();
效果图：![image](http://img.blog.csdn.net/20161113233620884)
### C
[CheckUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/CheckUtil.java) - 相关检查（Ps: checkNotNull 如果是 null 则抛出异常）

    checkNotNull(T t, Object) - 检测 T 如果是null，则抛出 NullPoint 并提示 String.valueOf(Object)
### D
[DateUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/DateUtil.java) - 日期工具类

    dayForWeek(long)                - 根据时间戳判断 星期几
    num_format(long , String)       - 时间戳转换相应格式日期
    birthDayToAge(String , String)  - 根据生日获取年龄， param1：生日 ，param2:生日格式
    getTimes(long , String)         - 设置时间(今天直接显示时间 HH:mm ， 昨天 ， 前天，yyyy[分隔符]MM[分隔符]dd）param2 为分隔符
    getPublishTime(long)            - 获取发表时间（刚刚，xx分钟前，xx小时前 ，xx天前）

[DialogUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/DialogUtil.java) - 创建 Dialog 工具类

    View view = LayoutInflater.from(context).inflate(layoutId , null);
    Dialog dialog = DialogUtil.createDialog(context ,view ,0.8f);
    // ... 实例化操作  TextView tv = LvV.find(view , id);
    dialog.show();
效果图：![image](http://img.blog.csdn.net/20160816093716112)

[DPUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/DPUtil.java) - 根据屏幕分辨率像素和 dp 互转，获取顶部状态栏高度

    dip2px(float);          - dip 转 Px
    px2dip(float);          - px 转 dip
    sp2px(float);           - sp 转 px
    px2sp(float);           - px 转 sp
    getStatusBarHeight();   - 获取状态栏高度
### E
[EmptyUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/EmptyUtil.java) - 对象空判断工具类

    isNull(Object)         
    isNotNull(Object)
    isNulls(Object... )
    isNotNulls(Object...)
[EncodeUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/EncodeUtil.java) - 字符串 MD5, SHA1 等加密

    MD5(String)            - 字符串 MD5 加密
    SHA1(String)           - 字符串 SHA1 加密
    SHA(String , SHA_TYPE) - 字符串进行其他 SHA 类型加密
    urlDecodeUtf8(String)  - 字符串 UrlDecode 解码
    urlEncodeUtf8(String)  - 字符串 Url Encode 编码
### F
[FragmentUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/FragmentUtil.java) - Fragment 控制类，目前主要用于切换界面中的多个 Fragment 显示

    replaceFragment(Fragment , int)   - 替换 Fragment
    showFragment(Fragment , int)      - 显示 Fragment
    
用法：

    在 BaseActivity or  BaseFragemnt 中，初始化，
    FragmentUtil fragmentUtil = new FragmentUtil(Manager)
    然后操作显示 Fragment 
### I
[IntentUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/IntentUtil.java) - Intent 跳转控制类

    // 跳转指定 Activity,携带参数，并且可回调到 Activity 中 onActivityResult 方法
    startActivity( FragmentActivity / V4.Fragment , Class clazz, Bundle bundle, int requestCode)
                 
    // 跳转指定 Activity ,回调到 Activity 中 onActivityResult 方法
    startActivity( FragmentActivity / V4.Fragment, Class clazz, int requestCode)
                         
    startActivity(Class clazz, Bundle bundle)   - 跳转指定界面，携带参数；
    startActivity(Class clazz)                  - 直接跳转指定界面；
    ------
    startAction(...)                            - 通过自定义、或者调用系统的 Action 来唤醒 Intent跳转
    
### K
[KeyBoardUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/KeyBoardUtil.java) - 键盘控制类

    showKeyBoard - 显示软键盘
    hideKeyBoard - 隐藏软键盘
### L
[LvLog.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvLog.java) - 打印 Log 工具类

    用法： 在 Application 中调用 LvUtils.init(Context).initLog(String tag，boolean isOpen)方法进行初始化。
    LvLog.i("");
    LvLog.d("");
    LvLog.e("");
    ...
### N
[NumberUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/NumberUtil.java) - 数字相关工具类

    maxKeepTwoDecimalPlaces(double); - 最多保留两位小数
    keepTwoDecimalPlaces(double);    - 始终保留两位小数
### S
[ScreenUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/ScreenUtil.java) - 获取屏幕尺寸工具类

    getScreenWidth()    - 获取屏幕宽度
    getScreenHeight()   - 获取屏幕高度

[SpUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/SpUtil.java) - SharedPreference工具类

    用法：
    在 Application 中 调用 LvUtils.init(Context).initSp(String spName) 方法。
    initSp
    
    setInt 
    setLong
    setBoolean
    setString
    setFloat
    
    getInt
    getLong
    getBoolean
    getString
    getFloat
    
    clear
    remove
[StringUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/StringUtil.java) - 意在整理一些常用 String 相关处理方法。后续逐步增加
    
    removeEnd(String ,String) - 字符串移除最后一次出现的 [参数2] 字符
### T
[ToastUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/ToastUtil.java) - Toast 工具类

    支持传入自定义视图
    -
    showToast   - 显示Toast
    cancel      - 取消Toast
    getToast    - 获取Toast
### V
[V.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/V.java) - 简化 findViewById ,显示明文密码，点击事件等 方法

    find(Activity, id);              - findViewById（）
    find(View , id);                 - findViewById（）
    find(Dialog , id);               - findViewById（）
    click(ClickListener, View...)    - view.setOnClickListener()
    showPassEdit(EditText , boolean) - 是否显示明文密码

[ViewHolder.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/ViewHolder.java) - 简化 ListView，GridView 的ViewHolder [Blog地址](http://blog.csdn.net/lv_fq/article/details/51913515)


## 功能整理
[DownloadDialog](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/DownloadDialog.java) - 版本更新提示
### 以上纯属个人项目工具类整理。
