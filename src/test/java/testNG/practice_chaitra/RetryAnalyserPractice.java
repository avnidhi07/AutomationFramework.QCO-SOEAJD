package testNG.practice_chaitra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = Generic_Utilities.RetryAnalyserImplementation.class)
	public void sample() {
		Assert.fail();
		System.out.println("Hello");
	}
}
