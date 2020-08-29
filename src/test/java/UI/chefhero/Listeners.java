package UI.chefhero;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNg;
import resources.base;

public class Listeners extends base  implements ITestListener {
		ExtentTest	 test;

	
	ExtentReports extent =  ExtentReportNg.getExtentReports();
	ThreadLocal<ExtentTest> extenttest= new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		
	 test=extent.createTest(result.getMethod().getMethodName());
	 extenttest.set(test);
	
	}

	public void onTestSuccess(ITestResult result) {
	extenttest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		
		WebDriver driver=null;
	String testcaseName=result.getMethod().getMethodName();
	try {
		
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e) {
		
	}
		
		try {
			
			extenttest.get().addScreenCaptureFromPath(getScreenshot(testcaseName, driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
