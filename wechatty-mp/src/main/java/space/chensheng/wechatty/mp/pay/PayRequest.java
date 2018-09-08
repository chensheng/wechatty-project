package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

@XStreamAlias("xml")
public abstract class PayRequest {
	
	@XStreamAlias("sign")
	@XStreamCDATA
	protected String sign;

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	@Override
	public String toString() {
		return XmlUtil.toXML(this);
	}
}
