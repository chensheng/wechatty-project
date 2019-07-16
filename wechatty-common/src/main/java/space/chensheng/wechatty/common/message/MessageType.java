package space.chensheng.wechatty.common.message;

public enum MessageType {
	EVENT("event"),
	TEXT("text"), 
	IMAGE("image"),
	VOICE("voice"),
	VIDEO("video"),
	MPVIDEO("mpvideo"),
	SHORTVIDEO("shortvideo"),
	LOCATION("location"),
	LINK("link"),
	FILE("file"),
	NEWS("news"),
	MPNEWS("mpnews"),
	MUSIC("music"),
	WXCARD("wxcard"),
	TRANSFER_CUSTOMER_SERVICE("transfer_customer_service");
	
	private String value;
	
	MessageType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
