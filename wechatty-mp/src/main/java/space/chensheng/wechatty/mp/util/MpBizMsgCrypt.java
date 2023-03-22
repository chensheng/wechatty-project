package space.chensheng.wechatty.mp.util;

import space.chensheng.wechatty.common.security.WXBizMsgCrypt;

public class MpBizMsgCrypt extends WXBizMsgCrypt {
    private MpAppContext appContext;

    public MpBizMsgCrypt(MpAppContext appContext) {
        this.appContext = appContext;
    }

    @Override
    protected String getAppId() {
        MpWechatContext wechatContext = (MpWechatContext) appContext.getWechatContext();
        return wechatContext.getAppId();
    }

    @Override
    protected String getToken() {
        MpWechatContext wechatContext = (MpWechatContext) appContext.getWechatContext();
        return wechatContext.getToken();
    }

    @Override
    protected String getEncodingAesKey() {
        MpWechatContext wechatContext = (MpWechatContext) appContext.getWechatContext();
        return wechatContext.getAesKey();
    }
}
