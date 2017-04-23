# Wechatty Project

Wechattty Project是一个基于JAVAR的微信公众号（包括服务号和订阅号）和微信企业号的开发框架，封装良好的API让开发者可以专注于业务逻辑的开发，提高开发效率。目前完成了微信公众号相关的部分功能，剩余功能将陆续完善，后在还将加入微信企业号开发的相关功能。

## 简单使用教程

* [引入依赖](#引入依赖)
* [配置](#配置)
* [接收消息](#接收消息)
* [发送消息](#发送消息)
* [素材管理](#素材管理)

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

### 接收消息

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
    public String verify(String msg_signature, String timestamp, String nonce, String echostr) {
        String reply = MpCallbackModeVerifier.verify(msg_signature, timestamp, nonce, echostr);
	return reply;
    }
    
    ...
}
```

###### 消息回调请求处理

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
    public String verify(String msg_signature, String timestamp, String nonce) {
        //postBody是请求体内容，String格式，开发者可以请求中解析
        String replyXml = messageDispatcher.dispatch(msg_signature(), timestamp, nonce, postBody);
	return replyXml;
    }
}
```

###### 回调消息的监听

开发者可以通过继承`space.chensheng.wechatty.common.message.MessageListener`来监听特定类型的消息，为了让监听生效，还需要将其添加到开头提到的Spring bean配置文件MpMessageDispatcher的msgListeners中去。以下是一个监听用户发送的文本消息的例子:

```
public class TextMessageListener extends MessageListener<TextInboundMessage> {

    @Override
    protected ReplyMessage onMessage(TextInboundMessage message) {
        String content = message.getContent();
	
	//根据消息内容来回复用户
	if ("1".equals(content)) {
	    TextReplyMessage replyMsg = new TextReplyMessage();
	    replyMsg.setContent("this is reply message content");
	    replyMsg.setFromUserName(message.getToUserName());
	    replyMsg.setToUserName(message.getFromUserName());
	    replyMsg.setCreateTime(System.currentTimeMillis());
	    return replyMsg;
	}
	
	//返回null表示不回复用户
	return null;
    }
}
```

###### 可监听的消息类型

消息|说明
---|---
TextInboundMessage|文本消息 
ImageInboundMessage|图片消息
LinkInboundMessage|跳转图文消息
LocationInboundMessage|共享位置消息
ShortVideoInboundMessage|小视频消息
VideoInboundMessage|视频消息
VoiceInboundMessage|语音消息
ClickEventMessage|点击普通菜单消息
ViewEventMessage|点击跳转链接菜单消息
LocationEventMessage|位置事件消息
SubscribeEventMessage|用户关注公众号消息
UnsubscribeEventMessage|用记取消关注公众号消息
ScanEventMessage|用户扫描二维码消息
MassSendJobFinishEventMessage|群发消息发送完成报告

###### 可回复的消息类型

消息|说明
---|---
TextReplyMessage|文本回复
ImageReplyMessage|图片回复
MusicReplyMessage|音乐回复
NewsReplyMessage|图文回复
VideoReplyMessage|视频回复
VoiceReplyMessage|语音回复

### 发送消息

公众号可以主动发送消息给用户，包括群发消息和客服消息两大类型消息。所有消息统一使用`space.chensheng.wechatty.mp.message.MpMessageSender`来发送。

###### 群发消息

```
TextMassMessage message = new TextMassMessage();
message.setIsToAll(true);
message.setContent("群发消息测试");
MpMessageSender.getInstance().send(message, 3);
```
群发消息类型|说明
-----|-----
TextMassMessage|文本群发
ImageMassMessage|图片群发
MpnewsMassMessage|微信内图文群发
MpvideoMassMessage|视频群发
VoiceMassMessage|语音群发
WxcardMassMessage|微信卡券群发

###### 客服消息

```
TextCsMessage message = new TextCsMessage();
message.setToUser("thisIsUserOpenId");
message.setContent("客服消息测试 \n 212");
MpMessageSender.getInstance().send(message, 3);
```
客服消息类型|说明
-----|-----
TextCsMessage|文本客服
ImageCsMessage|图片客服
MpnewsCsMessage|微信内图文客服
NewsCsMessage|外部图文客服
VideoCsMessage|视频客服
VoiceCsMessage|语音客服
WxcardCsMessage|微信卡券客服

### 素材管理

素材管理主要是进行素材的上传、查询、修改、删除，素材类型包括图片、视频、语音、图文。

###### 上传素材

上传素材通过操作对应的素材上传类来完成，下面是一个上传图片的例子：

```
File image = new File("/this/is/image/path.jpg");
ImagePermanentMedia material = new ImagePermanentMedia(image);
UploadResponse resp = material.upload();
```
素材上传类|说明
-----|-----
ImagePermanentMedia|永久图片
ThumbPermanentMedia|永久缩略图
VideoPermanentMedia|永久视频
VoicePermanentMedia|永久语音
PermanentNews|永久图文
PermanentNewsImg|永久图文中的图片
ImageTemporaryMedia|临时图片
ThumbTemporaryMedia|临时缩略图
VideoTemporaryMedia|临时视频
VoiceTemporaryMedia|临时语音

###### 查询素材

查询素材操作通过工具类`space.chensheng.wechatty.mp.material.MaterialQuery`和`space.chensheng.wechatty.mp.material.MaterialQuery`完成。

* 查询素材的数量信息：`MaterialQuery.count()`
* 查询图文素材：`MaterialQuery.listNews(int offset, int count)`
* 查询其他素材：`MaterialQuery.listMedia(MediaType mediaType, int offset, int count)`
* 根据mediaId查找图文：`MaterialFinder.findNews(String mediaId)`
* 根据mediaId查找永久视频：`MaterialFinder.findPermanentVideo(String mediaId)`
* 根据mediaId查找临时视频：`MaterialFinder.findTemporaryVideo(String mediaId)`
* 根据mediaId下载永久素材：`MaterialFinder.downloadPermanentMedia(String mediaId, String saveDir, String fileName)`
* 根据mediaId下载临时素材：`MaterialFinder.downloadTemporaryMedia(String mediaId, String saveDir, String fileName)`

###### 删除素材

删除素材操作通过工具类`space.chensheng.wechatty.mp.material.MaterialDeleter`完成。

* 根据mediaId删除素材：`MaterialDeleter.delete(String mediaId)`
