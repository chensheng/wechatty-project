package space.chensheng.wechatty.common.util;

public class JsonBean {
	
	@Override
	public String toString() {
		JsonMapper mapper = JsonMapper.nonEmptyMapper();
		String result = mapper.toJson(this);
		return result != null ? result : "{}";
	}
}
