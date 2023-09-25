package Generic_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for IRetryAnalyser interface of TestNG
 * @author avnish kumar
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount=2;
	@Override
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
		
	}

}
