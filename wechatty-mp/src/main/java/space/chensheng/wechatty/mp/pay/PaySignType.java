package space.chensheng.wechatty.mp.pay;

public enum PaySignType {
	MD5("MD5"),
	SHA1("SHA1");
	
	private String value;
	
	PaySignType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
