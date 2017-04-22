package space.chensheng.wechatty.common.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.BaseResponse;

public class SendMessageResponse extends BaseResponse {
	
	@JsonProperty("msg_id")
	private String msgId;
	
	@JsonProperty("msg_data_id")
	private String msgDataId;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgDataId() {
		return msgDataId;
	}

	public void setMsgDataId(String msgDataId) {
		this.msgDataId = msgDataId;
	}
}
