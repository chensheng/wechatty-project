package space.chensheng.wechatty.common.material;

public enum MediaType {
	IMAGE("image"),
	VIDEO("video"),
	VOICE("voice"),
	THUMB("thumb"),
	NEWS("news");
	
	private String value;
	
	MediaType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
