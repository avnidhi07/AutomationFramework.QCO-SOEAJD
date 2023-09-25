package Generic_Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used to random no genration
	 * @author avnish kumar
	 * @return
	 */
	public int getRandomNum() {
		Random r=new Random();
		int ranNum = r.nextInt(1000);
		return ranNum;
	}
	/**
	 * This method will generate the current system date in specified formate
	 * @return
	 */
	public String getSystemDate() {
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String date = formatter.format(d);
		return date;
		
	}

}
