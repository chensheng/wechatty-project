package space.chensheng.wechatty.common.util;

public class ExceptionUtil {
	public static String getExceptionDetails(Throwable cause) {
		StringBuilder details = new StringBuilder();
		if (cause != null) {
			details.append(cause.toString());
			StackTraceElement[] eles = cause.getStackTrace();
			if (eles != null) {
				for (StackTraceElement ele : eles) {
					details.append(ele.toString());
					details.append("\n");
				}
			}
		}
		return details.toString();
	}
}
