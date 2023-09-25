package testNG.practice_chaitra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider = "getData")
	public void addToCart(String name,String model,int price) {
		System.out.println(name+" - "+model+" - "+price);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data=new Object[4][3];
		data[0][0]="Samsung";
		data[0][1]="A80";
		data[0][2]=15000;
		
		data[1][0]="Oppo";
		data[1][1]="A12";
		data[1][2]=12000;
		
		data[2][0]="Iphone";
		data[2][1]="S13";
		data[2][2]=80000;
		
		data[3][0]="Vivo";
		data[3][1]="Y21";
		data[3][2]=19000;
		
		return data;
	}
}
