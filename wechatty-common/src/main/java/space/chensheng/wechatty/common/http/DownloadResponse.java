package space.chensheng.wechatty.common.http;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DownloadResponse extends BaseResponse {
	private static final long serialVersionUID = -68972996293569803L;
	
	@JsonIgnore
	private File file;

	public File getFile() {
		return file;
	}

	void setFile(File file) {
		this.file = file;
	}
	
	public String getFilePath() {
		if (file != null) {
			return file.getAbsolutePath();
		}
		
		return null;
	}
}
