package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsListResponse extends ListQueryResponse<NewsListResponse.Item> {
	private static final long serialVersionUID = -5495686608555237037L;

	public static class Item {
		@JsonProperty("media_id")
		private String mediaId;
		
		@JsonProperty("content")
		private News news;
		
		@JsonProperty("update_time")
		private Long updateTime;

		public String getMediaId() {
			return mediaId;
		}

		public News getNews() {
			return news;
		}
		
		public Long getUpdateTime() {
			return updateTime;
		}
	}
}
