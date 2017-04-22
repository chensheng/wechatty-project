package space.chensheng.wechatty.mp.message.outbound.cs;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.MessageType;
import space.chensheng.wechatty.mp.message.outbound.CsOutboundMessage;

public class NewsCsMessage extends CsOutboundMessage {
	
	@JsonProperty
	private News news;
	
	public NewsCsMessage() {
		super(MessageType.NEWS);
		news = new News();
	}
	
	public void addArticle(String title, String description, String url, String picUrl) {
		Article article = new Article();
		article.title = title;
		article.description = description;
		article.url = url;
		article.picUrl = picUrl;
		news.addArticle(article);
	}
	
	private static class News {
		@JsonProperty
		private List<Article> articles = new ArrayList<Article>();
		
		void addArticle(Article article) {
			articles.add(article);
		}
	}

	private static class Article {
		@JsonProperty
		private String title;
		
		@JsonProperty
		private String description;
		
		@JsonProperty
		private String url;
		
		@JsonProperty("picurl")
		private String picUrl;
	}
}
