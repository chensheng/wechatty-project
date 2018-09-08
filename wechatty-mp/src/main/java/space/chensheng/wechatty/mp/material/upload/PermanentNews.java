package space.chensheng.wechatty.mp.material.upload;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.conf.AppContext;
import space.chensheng.wechatty.common.material.Material;
import space.chensheng.wechatty.common.material.MaterialUploader;
import space.chensheng.wechatty.common.util.JsonBean;

public class PermanentNews extends Material {
	
	private MpNews mpNews;
	
	public PermanentNews(AppContext appContext) {
		super(appContext, "https://api.weixin.qq.com/cgi-bin/material/add_news");
		mpNews = new MpNews();
	}
	
	public void addArticle(String title, String thumbMediaId, String author, String digest, 
			String showCoverPic, String content, String contentSourceUrl) {
		Article article = new Article();
		article.title = title;
		article.thumbMediaId = thumbMediaId;
		article.author = author;
		article.digest = digest;
		article.showCoverPic = showCoverPic;
		article.content = content;
		article.contentSourceUrl = contentSourceUrl;
		mpNews.addArticle(article);
	}

	@Override
	protected void addQueryParam(Map<String, String> queryParams) {
		queryParams.put("access_token", this.getAppContext().getAccessTokenFetcher().getAccessToken());
	}

	@Override
	protected Object createPostBody() {
		return mpNews;
	}
	
	@Override
	protected MaterialUploader getUploader(AppContext appContext) {
		return appContext.getStringBodyUploader();
	}
	
	private static class MpNews extends JsonBean {
		@JsonProperty
		List<Article> articles = new ArrayList<Article>();
		
		void addArticle(Article article) {
			articles.add(article);
		}
	}

	private static class Article {
		
		@JsonProperty
		String title;
		
		@JsonProperty("thumb_media_id")
		String thumbMediaId;
		
		@JsonProperty
		String author;
		
		@JsonProperty
		String digest;
		
		@JsonProperty("show_cover_pic")
		String showCoverPic;
		
		@JsonProperty
		String content;
		
		@JsonProperty("content_source_url")
		String contentSourceUrl;
	}

}
