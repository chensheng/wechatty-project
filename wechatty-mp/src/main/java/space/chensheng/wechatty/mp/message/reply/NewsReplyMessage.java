package space.chensheng.wechatty.mp.message.reply;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.common.message.base.ReplyMessage;
import space.chensheng.wechatty.common.message.base.XmlMessage;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;

public class NewsReplyMessage extends ReplyMessage {

	@XStreamAlias("ArticleCount")
    @XStreamCDATA
	protected int articleCount;
	
	@XStreamAlias("Articles")
    @XStreamCDATA
	protected List<Article> articles;
	
	public NewsReplyMessage() {
		super(MessageType.NEWS);
		articles = new ArrayList<Article>();
	}
	
	public void addArticle(String title, String description, String picUrl, String url) {
		Article article = new Article();
		article.title = title;
		article.description = description;
		article.picUrl = picUrl;
		article.url = url;
		
		articles.add(article);
		articleCount = articles.size();
	}

	@XStreamAlias("item")
	private static class Article extends XmlMessage {
		@XStreamAlias("Title")
	    @XStreamCDATA
		protected String title;
		
		@XStreamAlias("Description")
	    @XStreamCDATA
		protected String description;
		
		@XStreamAlias("PicUrl")
	    @XStreamCDATA
		protected String picUrl;
		
		@XStreamAlias("Url")
	    @XStreamCDATA
		protected String url;
	}
}
