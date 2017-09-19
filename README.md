# AndroidUtils
整理项目常用的各种工具类

# How to 
## 从 1.1.3 版本开始调整以下依赖方式
### Jcenter 
    compile 'com.lfq:AndroidUtils:1.1.5'
### maven
    <dependency>
      <groupId>com.lfq</groupId>
      <artifactId>AndroidUtils</artifactId>
      <version>1.1.5</version>
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

[LvDPUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvDPUtil.java) - 根据屏幕分辨率像素和 dp 互转，获取顶部状态栏高度

[LvV.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvV.java) - 简化 findViewById 方法

[LvViewHolder.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvViewHolder.java) - 简化 ListView，GridView 的ViewHolder [Blog地址](http://blog.csdn.net/lv_fq/article/details/51913515)

[LvSpUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvSpUtil.java) - SharedPreference工具类

[LvToastUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvToastUtil.java) - Toast 工具类

[LvLog.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvLog.java) - 打印 Log 工具类

[LvDialogUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvDialogUtil.java) - 创建 Dialog 工具类

[LvBottomPopwin.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvBottomPopwin.java) - 底部弹出框工具类

[LvAppManager.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvAppManager.java) - 项目中的 Activity 管理类

[LvEmptyUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvEmptyUtil.java) - 对象空判断工具类

[LvScreenUtil.java](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvScreenUtil.java) - 获取屏幕尺寸工具类

[LvNumberUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvNumberUtil.java) - 数字相关工具类

[LvDateUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvDateUtil.java) - 日期工具类

[LvAndroidUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvAndroidUtil.java) - Android工具类(获取设备号，版本号..)

[LvKeyBoardUtil](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvKeyBoardUtil.java) - 键盘控制类

## 功能整理
[LvDownloadDialog](https://github.com/lvfaqiang/AndroidUtils/blob/master/library/src/main/java/com/lvfq/library/utils/LvDownloadDialog.java) - 版本更新提示
### 以上纯属个人项目工具类整理。
