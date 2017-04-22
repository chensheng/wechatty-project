package space.chensheng.wechatty.mp.material;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.BaseResponse;
import space.chensheng.wechatty.mp.material.News.Article;

public class NewsFindResponse extends BaseResponse {
	
	@JsonProperty("news_item")
	private List<Article> articleList;

	public List<Article> getArticleList() {
		return articleList;
	}
}
