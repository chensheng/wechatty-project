package space.chensheng.wechatty.mp.pay;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

@XStreamAlias("xml")
public class PayResponse {
	
	@XStreamAlias("return_code")
	@XStreamCDATA
	protected String returnCode;
	
	@XStreamAlias("return_msg")
	@XStreamCDATA
	protected String returnMsg;
	
	@XStreamAlias("sign")
	@XStreamCDATA
	protected String sign;
	
	@XStreamAlias("result_code")
	@XStreamCDATA
	protected String resultCode;

	@XStreamAlias("err_code")
	@XStreamCDATA
	private String errCode;
	
	@XStreamAlias("err_code_des")
	@XStreamCDATA
	private String errCodeDes;

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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}
	
	public boolean isSuccess() {
		return "SUCCESS".equals(this.returnCode) && "SUCCESS".equals(this.resultCode);
	}
}
