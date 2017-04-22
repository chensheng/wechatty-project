package space.chensheng.wechatty.common.http;


public class BaseResponse {
	private Integer errcode;
	
	private String errmsg;

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	
	public boolean isOk() {
		if (errcode == null) {
			return true;
		}
		
		if (errcode != null && errcode.equals(WechatErrorCode.OK)) {
			return true;
		}
		
		return false;
	}
	
	public boolean isAccessTokenError() {
		if (errcode != null && 
				(errcode.equals(WechatErrorCode.ACCESS_TOKEN_TIMEOUT )
				|| errcode.equals(WechatErrorCode.ACCESS_TOKEN_ILLEGAL)
				|| errcode.equals(WechatErrorCode.ACCESS_TOKEN_MISSING)
				|| errcode.equals(WechatErrorCode.ACCESS_TOKEN_INVALID))) {
			return true;
		}
		
		return false;
	}
}
