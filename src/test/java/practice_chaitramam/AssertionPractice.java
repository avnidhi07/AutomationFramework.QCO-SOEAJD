package practice_chaitramam;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void test1() {
		SoftAssert sa=new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		sa.assertTrue(false);
		System.out.println("Step 3");
		
		sa.assertEquals(1, 2);
		System.out.println("Step 4");
		Assert.assertEquals(false, true);
		System.out.println("Step 5");
		sa.assertAll();
	}
}
