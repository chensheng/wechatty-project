package space.chensheng.wechatty.mp.message.inbound.event;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import space.chensheng.wechatty.common.message.EventType;
import space.chensheng.wechatty.common.message.base.XmlMessage;
import space.chensheng.wechatty.common.util.XmlUtil.XStreamCDATA;
import space.chensheng.wechatty.mp.message.inbound.EventInboundMessage;

public class MassSendJobFinishEventMessage extends EventInboundMessage {

	@XStreamAlias("MsgID")
	private String msgId;
	
	@XStreamAlias("Status")
	@XStreamCDATA
	private String status;
	
	@XStreamAlias("TotalCount")
	private Integer totalCount;
	
	@XStreamAlias("FilterCount")
	private Integer filterCount;
	
	@XStreamAlias("SentCount")
	private Integer sentCount;
	
	@XStreamAlias("ErrorCount")
	private Integer errorCount;
	
	@XStreamAlias("CopyrightCheckResult")
	private CopyrightCheckResult copyrightCheckResult;
	
	public MassSendJobFinishEventMessage(EventType event) {
		super(EventType.MASSSENDJOBFINISH);
	}

	public String getMsgId() {
		return msgId;
	}

	public String getStatus() {
		return status;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public Integer getFilterCount() {
		return filterCount;
	}

	public Integer getSentCount() {
		return sentCount;
	}

	public Integer getErrorCount() {
		return errorCount;
	}
	
	public CopyrightCheckResult getCopyrightCheckResult() {
		return copyrightCheckResult;
	}

	@XStreamAlias("CopyrightCheckResult")
	public static class CopyrightCheckResult extends XmlMessage {
		
		@XStreamAlias("Count")
		private Integer count;
		
		@XStreamAlias("ResultList")
		private List<Item> resultList;

		public Integer getCount() {
			return count;
		}

		public List<Item> getResultList() {
			return resultList;
		}

	}
	
	@XStreamAlias("item")
	public static class Item extends XmlMessage {
		
		@XStreamAlias("ArticleIdx")
		private Integer articleIdx;
		
		@XStreamAlias("UserDeclareState")
		private String userDeclareState;
		
		@XStreamAlias("AuditState")
		private String auditState;
		
		@XStreamAlias("OriginalArticleUrl")
		@XStreamCDATA
		private String originalArticleUrl;
		
		@XStreamAlias("OriginalArticleType")
		private String originalArticleType;
		
		@XStreamAlias("CanReprint")
		private String canReprint;
		
		@XStreamAlias("NeedReplaceContent")
		private String needReplaceContent;
		
		@XStreamAlias("NeedShowReprintSource")
		private String needShowReprintSource;

		public Integer getArticleIdx() {
			return articleIdx;
		}

		public String getUserDeclareState() {
			return userDeclareState;
		}

		public String getAuditState() {
			return auditState;
		}

		public String getOriginalArticleUrl() {
			return originalArticleUrl;
		}

		public String getOriginalArticleType() {
			return originalArticleType;
		}

		public String getCanReprint() {
			return canReprint;
		}

		public String getNeedReplaceContent() {
			return needReplaceContent;
		}

		public String getNeedShowReprintSource() {
			return needShowReprintSource;
		}
		
	}
}
