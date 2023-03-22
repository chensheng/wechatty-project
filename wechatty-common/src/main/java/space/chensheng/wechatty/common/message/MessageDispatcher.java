package space.chensheng.wechatty.common.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.message.base.*;
import space.chensheng.wechatty.common.security.AesException;
import space.chensheng.wechatty.common.util.ExceptionUtil;
import space.chensheng.wechatty.common.util.XmlUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class MessageDispatcher {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageDispatcher.class);
	
	private static final String EMPTY_RESULT = "";
	
	private AppContext appContext;
	
	private Map<Class<?>, List<MessageListener<?>>> listenerPool;
	
	/**
	 * 
	 * @param appContext application context
	 * @param msgListeners to listen wechat inbound message
	 * @throws NullPointerException if appContext is null
	 */
	public MessageDispatcher(AppContext appContext, List<MessageListener<?>> msgListeners) {
		if (appContext == null) {
			throw new NullPointerException("appContext may not be null");
		}
		
		this.appContext = appContext;
		this.initListenerPool(msgListeners);
	}
	
	/**
	 * dispatch wechat inbound message to specify message listeners
	 * @param msgSignature message signature from wechat server
	 * @param timestamp timestamp of request
	 * @param nonce a random string
	 * @param postStream reqeust body stream from wechat server
	 * @return reply xml message or empty string
	 */
	public String dispatch(String msgSignature, String timestamp, String nonce, InputStream postStream) {
		if (postStream == null) {
			return EMPTY_RESULT;
		}
		
		String postData = readInputStream(postStream);
		return dispatch(msgSignature, timestamp, nonce, postData);
	}
	
	/**
	 * dispatch wechat inbound message to specified message listeners
	 * @param msgSignature message signature from wechat server
	 * @param timestamp timestamp of request
	 * @param nonce a random string
	 * @param postData reqeust body stream from wechat server
	 * @return reply xml message or empty string
	 */
	public String dispatch(String msgSignature, String timestamp, String nonce, String postData) {
		if (postData == null) {
			return EMPTY_RESULT;
		}
		
		String msgXml = resolveMsgXml(msgSignature, timestamp, nonce, postData);
		EmptyInboundMessage emptyMsg = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, EmptyInboundMessage.class);
		InboundMessage inboundMessage = resolveInboundMessage(emptyMsg, msgXml);
		
		return doDispatch(inboundMessage, timestamp, nonce);
	}
	
	private String resolveMsgXml(String msgSignature, String timestamp, String nonce, String postData) {
		if (!appContext.getWechatContext().getEnableCryptedMode()) {
			return postData;	
		}
		
		if (msgSignature == null || timestamp == null || nonce == null) {
			return EMPTY_RESULT;
		}
		
		EncryptedCallbackMessage message = XmlUtil.fromXMLIgnoreUnknownElements(postData, EncryptedCallbackMessage.class);
		if (message != null) {
			try {
				return appContext.getWxBizMsgCrypt().DecryptMsg(msgSignature, timestamp, nonce, message.getEncrypt());
			} catch (AesException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			}
		}
		
		return null;
	}
	
	private InboundMessage resolveInboundMessage(EmptyInboundMessage emptyMsg, String msgXml) {	
		if (emptyMsg == null || emptyMsg.getMsgType() == null || msgXml == null) {
			return null;
		}
		
		if (emptyMsg.getMsgType() == MessageType.EVENT) {
			return this.doResolveEventInbound(emptyMsg.getEvent(), msgXml);
		} else {
			return this.doResolveSimpleInbound(emptyMsg.getMsgType(), msgXml);
		}
	}
	
	private String doDispatch(InboundMessage inboundMsg, String timestamp, String nonce) {
		if (inboundMsg == null) {
			return EMPTY_RESULT;
		}
		
		ReplyMessage replyMsg = this.notifyListeners(inboundMsg);
		if (replyMsg == null) {
			return EMPTY_RESULT;
		}
		
		if (!appContext.getWechatContext().getEnableCryptedMode()) {
			return replyMsg.toString();
		}
		
		EncryptedReplyMessage encryptedReply = null;
		try {
			encryptedReply = appContext.getWxBizMsgCrypt().EncryptMsg(replyMsg, timestamp, nonce);
		} catch (AesException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		}
		if (encryptedReply != null) {
			return encryptedReply.toString();
		}
		
		return EMPTY_RESULT;
	}
	
	private void initListenerPool(List<MessageListener<?>> msgListeners) {
		listenerPool = new HashMap<Class<?>, List<MessageListener<?>>>();
		
		if (msgListeners != null && msgListeners.size() > 0) {
			for (MessageListener<?> listener : msgListeners) {
				Class<?> acceptableClass = listener.acceptableClass();
				if (!listenerPool.containsKey(acceptableClass)) {
					listenerPool.put(acceptableClass, new LinkedList<MessageListener<?>>());
				}
				listenerPool.get(acceptableClass).add(listener);
			}
		}
	}
	
	private ReplyMessage notifyListeners(InboundMessage message) {
		ReplyMessage result = null;
		
		List<MessageListener<?>> listeners = listenerPool.get(message.getClass());
		if (listeners != null && !listeners.isEmpty()) {
			for (MessageListener<?> listener : listeners) {
				result = listener.handleMessage(appContext.getWechatContext(), message);
			}
		}

		return result;
	}
	
	private String readInputStream(InputStream is) {
		StringBuilder result = new StringBuilder();
		String line = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			logger.error(ExceptionUtil.getExceptionDetails(e));
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				logger.error(ExceptionUtil.getExceptionDetails(e));
			}
		}
		
		return result.toString();
	}
	
	protected abstract InboundMessage doResolveSimpleInbound(MessageType msgType, String msgXml);
	
	protected abstract InboundMessage doResolveEventInbound(EventType eventType, String msgXml);
}
