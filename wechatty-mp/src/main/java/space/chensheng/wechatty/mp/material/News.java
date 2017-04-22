package space.chensheng.wechatty.mp.material;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class News {
	
	@JsonProperty("news_item")
	private List<Article> articleList;

	public List<Article> getArticleList() {
		return articleList;
	}
	
	public static class Article {
		@JsonProperty("title")
		private String title;
		
		@JsonProperty("thumb_media_id")
		private String thumbMediaId;
		
		@JsonProperty("show_cover_pic")
		private String showCoverPic;
		
		@JsonProperty("author")
		private String author;
		
		@JsonProperty("digest")
		private String digest;
		
		@JsonProperty("content")
		private String content;
		
		@JsonProperty("url")
		private String url;
		
		@JsonProperty("content_source_url")
		private String contentSourceUrl;

		public String getTitle() {
			return title;
		}

		public String getThumbMediaId() {
			return thumbMediaId;
		}

		public String getShowCoverPic() {
			return showCoverPic;
		}

		public String getAuthor() {
			return author;
		}

		public String getDigest() {
			return digest;
		}

		public String getContent() {
			return content;
		}

		public String getUrl() {
			return url;
		}

		public String getContentSourceUrl() {
			return contentSourceUrl;
		}
	}
}
