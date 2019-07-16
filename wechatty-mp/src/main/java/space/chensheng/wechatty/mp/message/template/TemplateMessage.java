package space.chensheng.wechatty.mp.message.template;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import space.chensheng.wechatty.common.message.base.OutboundMessage;

public class TemplateMessage extends OutboundMessage {
	public TemplateMessage() {
		super(null);
	}

	private String touser;
	
	@JsonProperty("template_id")
	private String templateId;
	
	private String url;
	
	private MiniProgram miniprogram;
	
	private Map<String, DataItem> data = new HashMap<String, DataItem>();
	
	/**
	 * Set template data.
	 * @param name required
	 * @param value required
	 * @param color optional
	 */
	public void addData(String name, String value, String color) {
		DataItem dataItem = new DataItem(value, color);
		data.put(name, dataItem);
	}
	
	public Map<String, DataItem> getData() {
		return data;
	}
	
	/**
	 * Optional.
	 * @param appid required
	 * @param pagepath optional
	 */
	public void setMiniprogram(String appid, String pagepath) {
		this.miniprogram = new MiniProgram(appid, pagepath);
	}
	
	public MiniProgram getMiniprogram() {
		return miniprogram;
	}
	
	public String getTouser() {
		return touser;
	}

	/**
	 * Required.
	 * @param touser
	 */
	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplateId() {
		return templateId;
	}

	/**
	 * Required.
	 * @param templateId
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	/**
	 * Optional.
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public static class MiniProgram {
		String appid;
		
		String pagepath;

		MiniProgram() {
		}
		
		MiniProgram(String appid, String pagepath) {
			this.appid = appid;
			this.pagepath = pagepath;
		}
		
		public String getAppid() {
			return appid;
		}

		public void setAppid(String appid) {
			this.appid = appid;
		}

		public String getPagepath() {
			return pagepath;
		}

		public void setPagepath(String pagepath) {
			this.pagepath = pagepath;
		}
	}
	
	public static class DataItem {
		String value;
		
		String color;
		
		public DataItem() {
		}
		
		public DataItem(String value, String color) {
			this.value = value;
			this.color = color;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}
}
