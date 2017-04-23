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

新建配置文件wechat-mp.properties, 将该文件放在项目类路径下。比如maven项目，可将该文件放在`src/main/resources`目录下。一般的配置如下:
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

###### access_token更新问题

* 自动更新：如果开启了自动更新，则在因为access_token错误而导致请求微信接口失败的情况下，框架会自动更新access_token。
* 定时更新：在应用中使用定时任务(比如quartz)来定时执行`space.chensheng.wechatty.mp.util.MpAccessTokenFetcher.getInstance().updateAccessToken()`，一般每1.5小时执行一次，因为access_token的过期时间为2小时。
* 自动更新和定时更新可共存，如果多个线程并发执行更新access_token，只有一个线程会去请求微信服务器来更新access_token，其他线程会立即返回，不执行任何操作。

###### access_token存取策略问题

* Web应用单机部署：如果您的应用是单机部署，则可直接使用默认的策略，将access_token存储在内存中。
* Web应用集群部署：如果您的应用是集群部署，则要实现自己的access_token存取策略，将access_token存放在集群共享的媒介（比如数据库）来达到access_token中控管理的目的。实现完自己的策略类后，要在wechat-mp.properties中添加配置`accessTokenStrategyClass=your.package.name.YourAccessTokenStrategyName`。以下是一个accesss_token数据库存取的策略：
```java
import space.chensheng.wechatty.common.http.AccessTokenStrategy;

//因为这个策略类的实例化不是通过Spring来管理的，所以在这个类中不能使用Autowired来注入bean，
//要通过ApplicationContext#getBean方法来获取。
public class DatabaseAccessTokenStrategy implements AccessTokenStrategy{
	
    //将access_token存到数据库中去
    @Override
    public void doSave(String accessToken) {
        TokenService tokenService = ApplicationContextUtil
	    .getApplicationContext().getBean(TokenService.class);
	tokenService.doSave(accessToken);
    }
    
    //从数据库中取出access_token
    @Override
    public String doQuery() {
        TokenService tokenService = ApplicationContextUtil
	    .getApplicationContext().getBean(TokenService.class);
	return tokenService.doQuery();
    }
}
```

### 回调消息

这里假设Web应用的bean是通过Spring来管理的。首先要在Spring配置文件中(比如applicationContext.xml)添加如下信息(关于message listener会在后面介绍):
```
<bean class="space.chensheng.wechatty.mp.message.MpMessageDispatcher">
  <constructor-arg name="msgListeners" >
    <list>
      <bean class="your.message.listener.TextMessageListener"></bean>
      <bean class="your.message.listener.SubscribeEventListener"></bean>
      <bean class="your.message.listener.listener.UnsubscribeEventListener"></bean>
    </list>
  </constructor-arg>
</bean>
```

###### 验证微信服务器的开启回调请求

如果你已经在微信公众号后台设置了回调URL，微信服务器会向这个URL发送一个GET请求来验证，开发者需要在Web应用中处理这个请求。以下是一个SpringMVC的验证例子：
```
@RestController
@RequestMapping(value = "/wechat-mp")
public class CallbackController extends BaseController{

    //注入前面配置的回调处理器
    @Autowired
    private MpMessageDispatcher messageDispatcher;
    
    //验证请求，并回复字符串
    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String verify(String msg_signature, String timestamp, String nonce, String echostr) throws ServiceLevelException {
        String reply = MpCallbackModeVerifier.verify(msg_signature, timestamp, nonce, echostr);
	return reply;
    }
    
    ...
}
```

###### 接收回调消息请求

验证完开启回调请求后，回调模式就真正开启了。如果用户发了个消息给公从号，微信服务器会向回调URL发送一个POST请求，将消息转发到这个URL上，开发者需要在Web应用中处理这个请求，以下是一个SpringMVC的例子（和前面验证开启回调的例子在一个controller中）：
```
@RestController
@RequestMapping(value = "/wechat-mp")
public class CallbackController extends BaseController{

    //注入前面配置的回调处理器
    @Autowired
    private MpMessageDispatcher messageDispatcher;
    
    //这里省略验证开启回调的方法
    ...
    
    //接收回调消息，并回复相应xml消息
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    public String verify(String msg_signature, String timestamp, String nonce) throws ServiceLevelException {
        //postBody是请求体内容，String格式，开发者可以请求中解析
        String replyXml = messageDispatcher.dispatch(msg_signature(), timestamp, nonce, postBody);
	return replyXml;
    }
}
```
