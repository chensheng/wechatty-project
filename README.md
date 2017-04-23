# Wechatty Project

Wechattty Project是一个基于JAVAR的微信公众号（包括服务号和订阅号）和微信企业号的开发框架，封装良好的API让开发者可以专注于业务逻辑的开发，提高开发效率。目前完成了微信公众号相关的部分功能，剩余功能将陆续完善，后在还将加入微信企业号开发的相关功能。

## 简单使用教程

* 引入依赖
* 配置

### 引入依赖

这里使用maven来引入依赖。
```
<dependency>
  <groupId>space.chensheng.wechatty</groupId>
  <artifactId>wechatty-mp</artifactId>
  <version>0.0.1</version>
</dependency>

```

### 配置

新建配置文件wechat-mp.properties, 将该文件放在项目类路径下。比如maven项目，可将该文件放在`src/main/resources`目录下。一般的配置同容如下:
```
token=thisIsTokenOfYourAccount
aesKey=thisIsAesKeyOfYourAccount
appId=thisIsYourAppId
appSecret=thisIdYourAppSecret
```

###### 配置参数说明

必填参数|说明
-----|-----
token|公众号的token，可在公众号后台查看.
aesKey|加密用的key， 可在公众号后台查看.
appId|公众号appId，可在公众号后台查看。
appSecret|公众号的appSecret，可在公众号后台查看。

