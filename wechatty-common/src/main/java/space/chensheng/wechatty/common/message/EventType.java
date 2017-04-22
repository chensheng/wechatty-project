package space.chensheng.wechatty.common.message;

public enum EventType {
	SUBSCRIBE("subscribe"),
	UNSUBSCRIBE("unsubscribe"),
	LOCATION("LOCATION"),
	CLICK("CLICK"),
	VIEW("VIEW"),
	SCAN("SCAN"),
	SCANCODE_PUSH("scancode_push"),
	SCANCODE_WAITMSG("scancode_waitmsg"),
	PIC_SYSPHOTO("pic_sysphoto"),
	PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),
	PIC_WEIXIN("pic_weixin"),
	LOCATION_SELECT("location_select"),
	ENTER_AGENT("enter_agent"),
	BATCH_JOB_RESULT("batch_job_result"),
	MASSSENDJOBFINISH("MASSSENDJOBFINISH");
	
	private String value;
	
	EventType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
