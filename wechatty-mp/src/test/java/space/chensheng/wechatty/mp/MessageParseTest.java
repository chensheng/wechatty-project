package space.chensheng.wechatty.mp;

import junit.framework.TestCase;
import space.chensheng.wechatty.mp.message.outbound.mass.MpnewsMassMessage;
import space.chensheng.wechatty.mp.message.reply.NewsReplyMessage;

public class MessageParseTest extends TestCase {
	public void testNewsReplyMessage() {
		NewsReplyMessage msg = new NewsReplyMessage();
		msg.setCreateTime(System.currentTimeMillis());
		msg.setFromUserName("chensheng");
		msg.setToUserName("shengchen");
		msg.addArticle("title1", "description1", "picUrl1", "url1");
		msg.addArticle("title2", "description2", "picUrl2", "url2");
		System.out.println(msg.toString());
	}
	
	public void testMpnewsMassMessage() {
		MpnewsMassMessage msg = new MpnewsMassMessage();
		msg.setIsToAll(true);
		msg.setTagId("1234");
		msg.setMediaId("dshfksdhss");
		msg.sendIgnoreReprint();
		System.out.println(msg);
	}
}
