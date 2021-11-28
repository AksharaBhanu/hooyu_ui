package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GenericUtils {
	
	
	public static String getCreateRepoInputJson(String name, String Val) {
		
		String inputJson = "{\r\n"
				+ "    \""+name+"\": \""+Val+"\"\r\n"
				+ "}";
		return inputJson;		
	}
		
	public static String getProperties(String propertyFileName, String propertyKey) {
		String keyVal=null;
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/"+propertyFileName+".properties");
			Properties prop = new Properties();
			prop.load(fis);	
			keyVal = prop.getProperty(propertyKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return keyVal;
	}
}
