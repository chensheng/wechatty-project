package space.chensheng.wechatty.mp.material;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.http.BaseResponse;

public abstract class ListQueryResponse<T> extends BaseResponse {
	private static final long serialVersionUID = 3191917026129382609L;

	@JsonProperty("total_count")
	private Integer totalCount;
	
	@JsonProperty("item_count")
	private Integer itemCount;
	
	@JsonProperty("item")
	private List<T> itemList;

	public Integer getTotalCount() {
		return totalCount;
	}

	public Integer getItemCount() {
		return itemCount;
	}
	
	public List<T> getItemList() {
		return itemList;
	}
}
