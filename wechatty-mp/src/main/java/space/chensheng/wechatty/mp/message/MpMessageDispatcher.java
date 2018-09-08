package space.chensheng.wechatty.mp.message;

import java.util.List;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.message.EventType;
import space.chensheng.wechatty.common.message.MessageDispatcher;
import space.chensheng.wechatty.common.message.MessageListener;
import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.InboundMessage;
import space.chensheng.wechatty.common.util.XmlUtil;
import space.chensheng.wechatty.mp.message.inbound.event.ClickEventMessage;
import space.chensheng.wechatty.mp.message.inbound.event.LocationEventMessage;
import space.chensheng.wechatty.mp.message.inbound.event.MassSendJobFinishEventMessage;
import space.chensheng.wechatty.mp.message.inbound.event.ScanEventMessage;
import space.chensheng.wechatty.mp.message.inbound.event.SubscribeEventMessage;
import space.chensheng.wechatty.mp.message.inbound.event.UnsubscribeEventMessage;
import space.chensheng.wechatty.mp.message.inbound.event.ViewEventMessage;
import space.chensheng.wechatty.mp.message.inbound.simple.ImageInboundMessage;
import space.chensheng.wechatty.mp.message.inbound.simple.LinkInboundMessage;
import space.chensheng.wechatty.mp.message.inbound.simple.LocationInboundMessage;
import space.chensheng.wechatty.mp.message.inbound.simple.ShortVideoInboundMessage;
import space.chensheng.wechatty.mp.message.inbound.simple.TextInboundMessage;
import space.chensheng.wechatty.mp.message.inbound.simple.VideoInboundMessage;
import space.chensheng.wechatty.mp.message.inbound.simple.VoiceInboundMessage;

public class MpMessageDispatcher extends MessageDispatcher {

	public MpMessageDispatcher(AppContext appContext, List<MessageListener<?>> msgListeners) {
		super(appContext, msgListeners);
	}

	@Override
	protected InboundMessage doResolveSimpleInbound(MessageType msgType, String msgXml) {
		InboundMessage result = null;
		
		if (msgType == MessageType.TEXT) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, TextInboundMessage.class);
		} else if (msgType == MessageType.IMAGE) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, ImageInboundMessage.class);
		} else if (msgType == MessageType.LINK) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, LinkInboundMessage.class);
		} else if (msgType == MessageType.LOCATION) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, LocationInboundMessage.class);
		} else if (msgType == MessageType.SHORTVIDEO) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, ShortVideoInboundMessage.class);
		} else if (msgType == MessageType.VIDEO) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, VideoInboundMessage.class);
		} else if (msgType == MessageType.VOICE) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, VoiceInboundMessage.class);
		}
		
		return result;
	}

	@Override
	protected InboundMessage doResolveEventInbound(EventType eventType, String msgXml) {
		InboundMessage result = null;
		
		if (eventType == EventType.CLICK) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, ClickEventMessage.class);
		} else if (eventType == EventType.LOCATION) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, LocationEventMessage.class);
		} else if (eventType == EventType.SCAN) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, ScanEventMessage.class);
		} else if (eventType == EventType.SUBSCRIBE) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, SubscribeEventMessage.class);
		} else if (eventType == EventType.UNSUBSCRIBE) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, UnsubscribeEventMessage.class);
		} else if (eventType == EventType.VIEW) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, ViewEventMessage.class);
		} else if (eventType == EventType.MASSSENDJOBFINISH) {
			result = XmlUtil.fromXMLIgnoreUnknownElements(msgXml, MassSendJobFinishEventMessage.class);
		}
		
		return result;
	}
	
	
}
