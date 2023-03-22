package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.http.AccessTokenFetcher;

import java.util.HashMap;
import java.util.Map;

public class DelegateAccessTokenFetcher implements AccessTokenFetcher {
    private MpAppContext appContext;

    private Map<String, AccessTokenFetcher> fetcherMap = new HashMap<String, AccessTokenFetcher>();

    public DelegateAccessTokenFetcher(MpAppContext appContext) {
        this.appContext = appContext;
        for(WechatContext wechatContext : appContext.getWechatContexts()) {
            fetcherMap.put(wechatContext.getContextId(), new MpAccessTokenFetcher(appContext, (MpWechatContext) wechatContext));
        }
    }

    @Override
    public void updateAccessToken() {
        AccessTokenFetcher fetcher = doFindFetcher();
        fetcher.updateAccessToken();
    }

    @Override
    public String getAccessToken() {
        AccessTokenFetcher fetcher = doFindFetcher();
        return fetcher.getAccessToken();
    }

    @Override
    public void updateIfNecessary(Object resp) {
        AccessTokenFetcher fetcher = doFindFetcher();
        fetcher.updateIfNecessary(resp);
    }

    @Override
    public void batchUpdateAccessToken() {
        for(AccessTokenFetcher fetcher : fetcherMap.values()) {
            fetcher.updateAccessToken();
        }
    }

    private AccessTokenFetcher doFindFetcher() {
        MpWechatContext context = (MpWechatContext) appContext.getWechatContext();
        String appId = context.getAppId();
        AccessTokenFetcher fetcher = fetcherMap.get(appId);
        return fetcher;
    }
}
