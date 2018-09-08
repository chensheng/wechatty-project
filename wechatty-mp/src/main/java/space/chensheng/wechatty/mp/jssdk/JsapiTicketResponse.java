package space.chensheng.wechatty.mp.jssdk;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.BaseResponse;

public class JsapiTicketResponse extends BaseResponse {
	private static final long serialVersionUID = 7217735914420141650L;

	private String ticket;
	
	@JsonProperty("expires_in")
	private Integer expiresIn;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
}
