package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

@XStreamAlias("xml")
public class PayNotifyFeedback {
	public static final PayNotifyFeedback SUCCESS = new PayNotifyFeedback("SUCCESS", "OK");
	
	public static final PayNotifyFeedback FAIL = new PayNotifyFeedback("FAIL", "FAIL");
	
	@XStreamAlias("return_code")
	@XStreamCDATA
	protected String returnCode;
	
	@XStreamAlias("return_msg")
	@XStreamCDATA
	protected String returnMsg;
	
	public PayNotifyFeedback() {
		
	}
	
	public PayNotifyFeedback(String returnCode, String returnMsg) {
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	
	@Override
	public String toString() {
		return XmlUtil.toXML(this);
	}
}
