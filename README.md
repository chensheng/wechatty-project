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

可选参数|说明
-----|-----
enableCryptedMode|是否开启回调加密模式，默认true。如果开启则要下载[JCE无限制权限策略文件](http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html),覆盖jdk中的相关文件，具体可查看[微信常见错误举例](https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318482&lang=zh_CN)。
autoUpdateAccessToken|出现access_token相关错误时是否自动更新access_token，默认false，应用可自己通过定时任务来更新，后面将详细介绍。
accessTokenStrategyClass|access_token存取策略，默认是space.chensheng.wechatty.common.http.MemoryAccessTokenStrategy，将access_token存在内存中，应用可实现自己的存取策略，比如存在数据库中，后面将详细介绍。
poolingHttpProxyEnable|是否通过代理服务器给微信服务器必请求，默认false
poolingHttpProxyHostname|代理服务器的hostname，比如www.chensheng.space
poolingHttpProxyPort|代理服务器端口
poolingHttpProxyUsername|代理服务器用户名
poolingHttpProxyPassword|代理服务器密码
poolingHttpMaxPerRoute|http连接池每条链路最大并发连接数，默认为50
poolingHttpMaxTotal|http连接池最大并发连接数，默认200
poolingHttpSocketTimeoutMillis|socket超时毫秒数，默认10000
poolingHttpConnectTimeoutMillis|连接到微信服务器超时毫秒数，默认10000
poolingHttpConnectionRequestTimeoutMillis|从htttp连接池获取连接超时毫秒数，默认10000
poolingHttpTcpNoDelay|是否开启tpcNoDelay,默认true
