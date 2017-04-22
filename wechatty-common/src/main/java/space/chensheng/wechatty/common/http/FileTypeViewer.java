package space.chensheng.wechatty.common.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileTypeViewer {
	
	public static FileType getType(String filePath) throws IOException { 
        return doGetType(getFileHeader(filePath));
    }  
    
    public static FileType getType(InputStream is) throws IOException {
        return doGetType(getFileHeader(is));
    }
    
    public static FileType getType(File file) throws IOException {  
        return doGetType(getFileHeader(file));
    }
    
    private static FileType doGetType(String fileHeader) {
    	if (fileHeader == null || fileHeader.length() == 0) {  
            return null;  
        }  
        fileHeader = fileHeader.toUpperCase();  
        FileType[] fileTypes = FileType.values();  
        for (FileType type : fileTypes) {  
            if (fileHeader.startsWith(type.getValue())) {  
                return type;  
            }  
        }
        return null;  
    }
	
	private static String getFileHeader(String filePath) throws IOException {
		InputStream inputStream = new FileInputStream(filePath);
        return getFileHeader(inputStream);
    }
	
	private static String getFileHeader(File file) throws IOException {
    	if (file == null) {
    		return "";
    	}
		InputStream inputStream = new FileInputStream(file);
        return getFileHeader(inputStream);
    }
	
    private static String getFileHeader(InputStream inputStream) throws IOException {
    	if (inputStream == null) {
    		return "";
    	}
    	byte[] b = new byte[28];
    	try {
            inputStream.read(b, 0, 28);
        } finally {
            if (inputStream != null) {
            	inputStream.close();
            }
        }
        return bytesToHexString(b); 
    }
    
    private static String bytesToHexString(byte[] src){
		StringBuilder stringBuilder = new StringBuilder();     
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
    
    public static enum FileType {
        JPEG("FFD8FF", "jpg"),  
        PNG("89504E47", "png"),  
        GIF("47494638", "gif"),  
        TIFF("49492A00", "tiff"),  
        BMP("424D", "bmp"),  
        DWG("41433130", "dwg"),  
        PSD("38425053", "psd"),  
        RTF("7B5C727466", "rtf"),  
        XML("3C3F786D6C", "xml"),  
        HTML("68746D6C3E", "html"),  
        EML("44656C69766572792D646174653A", "eml"),  
        DBX("CFAD12FEC5FD746F", "dbx"),  
        PST("2142444E", "pst"),  
        XLS_DOC("D0CF11E0", "doc"),  
        MDB("5374616E64617264204A", "mdb"),  
        WPD("FF575043", "wpd"),  
        EPS("252150532D41646F6265", "eps"),  
        PDF("255044462D312E", "pdf"),  
        QDF("AC9EBD8F", "qdf"),  
        PWL("E3828596", "pwl"),  
        ZIP("504B0304", "zip"),  
        RAR("52617221", "rar"),  
        WAV("57415645", "wav"),  
        AVI("41564920", "avi"),  
        RAM("2E7261FD", "ram"),  
        RM("2E524D46", "rm"),  
        MPG("000001BA", "mpg"),  
        MOV("6D6F6F76", "mov"),  
        ASF("3026B2758E66CF11", "asf"),  
        MID("4D546864", "mid");
          
        private String value;  
        
        private String ext;
          
        private FileType(String value, String ext) {  
            this.value = value;  
            this.ext = ext;
        }  
      
        public String getValue() {  
            return value;  
        }  
      
        public void setValue(String value) {  
            this.value = value;  
        }  
        
        public String getExt() {
        	return ext;
        }
    }
}
