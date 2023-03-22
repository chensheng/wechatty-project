package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.conf.WechatContext;
import space.chensheng.wechatty.common.http.HttpClientCustomizer;
import space.chensheng.wechatty.common.http.PoolingHttpClient;
import space.chensheng.wechatty.common.http.PoolingHttpUtil;
import space.chensheng.wechatty.mp.pay.PayCertHttpCustomizer;

import java.util.HashMap;
import java.util.Map;

public class MpPoolingHttpUtil extends PoolingHttpUtil {
    private Map<String, PoolingHttpClient> clientMap = new HashMap<String, PoolingHttpClient>();

    private MpAppContext appContext;

    public MpPoolingHttpUtil(MpAppContext appContext, boolean enablePayCert) {
        this.appContext = appContext;

        for(WechatContext context : appContext.getWechatContexts()) {
            MpWechatContext wechatContext = (MpWechatContext) context;
            HttpClientCustomizer customizer = null;
            if(enablePayCert && wechatContext.getPayCertFile() != null && wechatContext.getPayCertPassword() != null) {
                customizer = new PayCertHttpCustomizer();
            }
            PoolingHttpClient client = new PoolingHttpClient(wechatContext, customizer);
            clientMap.put(wechatContext.getAppId(), client);
        }
    }

    @Override
    protected PoolingHttpClient getClient() {
        MpWechatContext wechatContext = (MpWechatContext) appContext.getWechatContext();
        String appId = wechatContext.getAppId();
        return clientMap.get(appId);
    }
}
