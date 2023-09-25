package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx {

	@DataProvider
	public Object[][] getData() {
		String[][] data= {
				{"bangalore","mumbai"},
				{"mumbai","bangalore"}
				};
		;
		return data;
	}
	@Test
	public void bookTicket(String src,String dest) {
		
	}
}
