package util;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class PropertiesConfig {
	private static String PROPERTIESFILENAME = "properties_zh";
	
	private static ResourceBundle resourceBundle=ResourceBundle.getBundle(PROPERTIESFILENAME);;
	
	public static String getStr(String key){
		String str = resourceBundle.getString(key);
		try {
			return new String(str.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getInt(String key){
		String str = resourceBundle.getString(key);
		try {
			str= new String(str.getBytes("iso-8859-1"), "UTF-8");
			return Integer.valueOf(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static void main(String args[]){
		System.out.println(PropertiesConfig.getStr("test"));
	}
}
