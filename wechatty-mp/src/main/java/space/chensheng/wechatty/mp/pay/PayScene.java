package space.chensheng.wechatty.mp.pay;

public enum PayScene {
	SCENE_SALES_PROMOTION("PRODUCT_1"),
	SCENE_DRAW("PRODUCT_2"),
	SCENE_VIRTUAL_PRODUCT("PRODUCT_3"),
	SCENE_ENTERPRISE_WELFARE("PRODUCT_4"),
	SCENE_CHANNEL_PROFIT("PRODUCT_5"),
	SCENE_INSURANCE("PRODUCT_6"),
	SCENE_LOTTERY("PRODUCT_7"),
	SCENE_TAX_LOTTERY("PRODUCT_8");
	
	private String value;
	
	PayScene(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
