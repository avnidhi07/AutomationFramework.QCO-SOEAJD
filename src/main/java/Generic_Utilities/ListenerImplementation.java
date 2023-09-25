package Generic_Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----Test script execution started-----");
		
		//create a test in extent report
		test=report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"------ PASS ------");
		test.log(Status.PASS, methodName+"----PASS---------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriverUtility w=new WebDriverUtility();
		JavaUtility j=new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
		String screenshotName = methodName+j.getSystemDate();
		System.out.println(result.getThrowable());
		System.out.println(methodName+"------ FAIL ------");
		test.log(Status.FAIL, methodName+"----FAIL------");
		test.log(Status.INFO, result.getThrowable());
		
		try {
			String path = w.captureScreenShot(BaseClass.sdriver, screenshotName);
			//attach the screenshot into the report
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getThrowable()); 
		String methodname = result.getMethod().getMethodName(); 
		System.out.println(methodname+" ----- SKIP -----"); 
		test.log(Status.SKIP, methodname+"-------SKIP------");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("----- Suite execution started -----");
		
		//Configure the extent Reports
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("Automation Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Avnish");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("----- Suite execution finished -----");
		//genrate the report after execution
		report.flush();
	}

	
}
