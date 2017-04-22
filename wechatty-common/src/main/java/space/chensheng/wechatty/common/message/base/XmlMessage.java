package space.chensheng.wechatty.common.message.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil;

@XStreamAlias("xml")
public abstract class XmlMessage implements WechatMessage {

	@Override
	public String toString() {
		return XmlUtil.toXML(this);
	}
}
