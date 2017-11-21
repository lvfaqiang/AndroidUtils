# AndroidUtils
整理项目常用的各种工具类
##<font color="blue">注</font> ： 2.0 版本调整除 LvUtils ， LvLog 之外，其他工具类全部移除 Lv 前缀。
# How to 
## 从 1.1.3 版本开始调整以下依赖方式
### Jcenter 
    compile 'com.lfq:AndroidUtils:2.0'
### maven
    <dependency>
      <groupId>com.lfq</groupId>
      <artifactId>AndroidUtils</artifactId>
      <version>1.1.6</version>
      <type>pom</type>
    </dependency>
## 1.1.2 版本及以前版本用法
先在 build.gradle(Project:XXXX) 的 repositories 添加:

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
### 添加依赖
	compile 'com.github.lvfaqiang:AndroidUtils:VERSION_CODE'
	
[历史版本](https://github.com/lvfaqiang/AndroidUtils/releases)(**注:** 1.1.3+ 请更换 Jcenter / maven 依赖)

[功能清单](https://github.com/lvfaqiang/AndroidUtils/wiki)

[更新日志](https://github.com/lvfaqiang/AndroidUtils/wiki/Log)

## 资源文件
[dimens.xml](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/res/values/dimens.xml) - 尺寸单位（1-375dp , 1-50sp , 1-375px）

[colors.xml](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/res/values/colors.xml) - 整理了几个项目所用的颜色值（c_xxxxxx : 表示 完整颜色值 , color_ab : 表示 ababab 类型颜色值）

## 工具类列表：

[DPUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/DPUtil.java) - 根据屏幕分辨率像素和 dp 互转，获取顶部状态栏高度

[V.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/V.java) - 简化 findViewById ,显示明文密码，点击事件等 方法

[ViewHolder.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/ViewHolder.java) - 简化 ListView，GridView 的ViewHolder [Blog地址](http://blog.csdn.net/lv_fq/article/details/51913515)

[SpUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/SpUtil.java) - SharedPreference工具类

[ToastUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/ToastUtil.java) - Toast 工具类

[LvLog.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvLog.java) - 打印 Log 工具类

[DialogUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/DialogUtil.java) - 创建 Dialog 工具类

[BottomPopwin.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/BottomPopwin.java) - 底部弹出框工具类

[AppManager.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/AppManager.java) - 项目中的 Activity 管理类

[EmptyUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/EmptyUtil.java) - 对象空判断工具类

[ScreenUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/ScreenUtil.java) - 获取屏幕尺寸工具类

[NumberUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/NumberUtil.java) - 数字相关工具类

[DateUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/DateUtil.java) - 日期工具类

[AndroidUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/AndroidUtil.java) - Android工具类(获取设备号，版本号..)

[KeyBoardUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/KeyBoardUtil.java) - 键盘控制类

[FragmentUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/FragmentUtil.java) - Fragment 控制类，目前主要用于切换界面中的多个 Fragment 显示

[EncodeUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/EncodeUtil.java) - 字符串 MD5, SHA1 等加密

[StringUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/StringUtil.java) - 意在整理一些常用 String 相关处理方法。后续逐步增加

## 功能整理
[DownloadDialog](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/DownloadDialog.java) - 版本更新提示
### 以上纯属个人项目工具类整理。
