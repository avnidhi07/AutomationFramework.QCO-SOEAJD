package practiceTestNG;

import org.testng.annotations.Test;

public class TestNGClass {

	@Test(priority = 2)
	public void createProduct() {
		System.out.println("product is created");
	}
	
	@Test(priority = 1)
	public void modifiedProduct() {
		System.out.println("product is modified");
	}
	
	@Test(invocationCount = 2)
	public void deletedProduct() {
		System.out.println("product is deleted");
	}
}
