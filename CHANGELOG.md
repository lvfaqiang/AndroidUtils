## ChangeLog
### 2017年12月21日
新增 **CheckUtil**

    checkNotNull(T t, Object) - 检测 T 如果是null，则抛出 NullPoint 并提示 String.valueOf(Object)
### 2017年12月20日
去掉 Multidex 引用

新增 IntentUtil       - Intent 跳转工具类<br/>

新增 AppUtil          - 从之前的 AndroidUtil 中分离出来。

    新增 isAppRunningForeground 应用是否运行在前台
    新增 isServiceRunning(String) 某服务是否在运行
修改 AndroidUtil      - 分离出  AppUtil 用于区分应用级别（AppUtil）工具类，和设备级（AndroidUtil）工具类，<br/>

修改 LvLog            - 内部修改，使用方式不需修改<br/>

EncodeUtil

    新增 urlDecoderUtf8(String) URL Decode 方法
    UTF8(String) -> urlEncodeUtf8(String) 方法名调整

调整 README 排版，<br/>
调整 清单列表，


### 2017/11/21:
### 大改一次，更新版本为 2.0

AndroidUtil 

    新增 callPhoneAuto ， callPhone 等拨打电话方法
    新增 getAppIcon 获取当前应用图标 Id 
    新增 getAppName 获取当前应用名称

V  - 新增 showPassEdit 是否显示明文密码方法

StringUtil - 新增类，字符串常用处理方法。

EncodeUtil - 新增类 ， 常用字符的加密，编码。
### 2017/09/12:
LvAndroidUtil - 新增 installApk 方法。

LvAppManager - 调整 AppExit 方法，新增控制是否调用 killProcess 参数。
### 2017/09/04:
LvSpUtil - 取消对 Gson 包的依赖，独立出配合 Gson 实现对象、集合的存储。

LvV      - 新增 click(View.OnClickListener , View...) 批量设置监听方法。

LvEmptyUtil：

    isEmpty     ->  isNull
    isNotEmpty  ->  isNotNull
    isEmptys    ->  isNulls
    isNotEmptys ->  isNotNulls

### 2017/08/31:
LvDownloadDialog - 新增版本更新弹框

LvAppManager： 

    修改 AppExit() 方法，退出程序时，直接 kill 掉。

LvDialogUtil：

    调整内部方法 , 不影响方法调用。
LvLog:

    添加初始默认 tag = "LvUtils"
LvV:

    添加 find(Dialog,id) 方法，支持传入 Dialog
其他：

    添加 dimens 配置文件，包含 1-100dp, 1-30sp , 1-100px 
    添加 默认 dialog 圆角白色背景 shape 文件：shape_bg_white_radius_5.xml
### 2017/08/16:
LvAndroidUtil 添加对比版本号方法；<br/>

LvEmptyUtil 修改判断多个对象为空和不为空的方法名。

