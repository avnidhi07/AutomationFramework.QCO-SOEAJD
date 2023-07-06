package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public String getPropertyData(String key) throws IOException {

		FileInputStream fis=new FileInputStream("./src/test/resources/configfile/config.properties");
		
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
		

	}

}
