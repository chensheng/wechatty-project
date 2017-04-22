package space.chensheng.wechatty.mp.material;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaListResponse extends ListQueryResponse<MediaListResponse.Item> {
	
	public static class Item {
		@JsonProperty("media_id")
		private String mediaId;
		
		@JsonProperty
		private String name;
		
		@JsonProperty("update_time")
		private Long updateTime;
		
		@JsonProperty
		private String url;

		public String getMediaId() {
			return mediaId;
		}

		public String getName() {
			return name;
		}

		public Long getUpdateTime() {
			return updateTime;
		}

		public String getUrl() {
			return url;
		}
		
	}
}
