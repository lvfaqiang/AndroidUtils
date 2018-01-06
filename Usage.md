## How to Use
#### <font color="blue">注</font> ： 2.x 版本调整除 LvUtils ， LvLog 之外，其他工具类全部移除 Lv 前缀。
### 从 1.1.3 版本开始调整以下依赖方式
### Jcenter 
    compile 'com.lfq:AndroidUtils:LATEST_VERSION'
### maven
    <dependency>
      <groupId>com.lfq</groupId>
      <artifactId>AndroidUtils</artifactId>
      <version>LATEST_VERSION</version>
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
	compile 'com.github.lvfaqiang:AndroidUtils:LATEST_VERSION'
	
[版本号列表](https://github.com/lvfaqiang/AndroidUtils/tags)(**注:** 1.1.3+ 请更换 Jcenter / maven 依赖) 