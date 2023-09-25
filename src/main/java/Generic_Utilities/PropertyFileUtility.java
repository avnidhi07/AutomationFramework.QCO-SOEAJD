package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {

	/**
	 * This method will read data from property file and return the value to caller
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author avnish kumar
	 */

	public String getLaunchBrowswer(String key) throws Throwable {
	
	//Step 1: Open the document in java readable format	
	FileInputStream fis=new FileInputStream("./src/test/resources/configfile/vtiger.properties");
	//Step 2: Create object properties class - java.util
	Properties p=new Properties();
	//Step 3: Load the document into properties class
	p.load(fis);
	//Step 4: provide the key and read the value
	String value = p.getProperty(key);
	return value;
 }

}
