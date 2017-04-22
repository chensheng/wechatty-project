package space.chensheng.wechatty.common.message.base;

import space.chensheng.wechatty.common.util.JsonMapper;

public abstract class JsonMessage implements WechatMessage {

	@Override
	public String toString() {
		JsonMapper mapper = JsonMapper.nonEmptyMapper();
		String result = mapper.toJson(this);
		return result != null ? result : "{}";
	}
}
