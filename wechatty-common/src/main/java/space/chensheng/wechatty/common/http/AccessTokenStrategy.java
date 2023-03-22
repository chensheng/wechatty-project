package space.chensheng.wechatty.common.http;

import space.chensheng.wechatty.common.conf.WechatContext;

public interface AccessTokenStrategy {
	/**
	 * save access token to memory, database or other medias
	 * @param accessToken access token of wechat
	 * @deprecated implements {@link #doSave(WechatContext, String)} instead
	 */
	default void doSave(String accessToken) {

	}
	
	/**
	 * query access token from memory, database or other medias
	 * @return access token of wechat
	 * @deprecated implements {@link #doQuery(WechatContext)} instead
	 */
	default String doQuery() {
		return null;
	}

	/**
	 * save access token to memory, database or other medias
	 * @param wechatContext wechat context
	 * @param accessToken access token of wechat
	 */
	default void doSave(WechatContext wechatContext, String accessToken) {
		this.doSave(accessToken);
	}

	/**
	 * query access token from memory, database or other medias
	 * @param wechatContext wechat context
	 * @return access token of wechat
	 */
	default String doQuery(WechatContext wechatContext) {
		return this.doQuery();
	}
}
