package space.chensheng.wechatty.mp.pay;

public enum TradeType {
	JSAPI("JSAPI"),
	NATIVE("NATIVE"),
	APP("APP");
	
	private String value;
	
	TradeType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
