package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
	 static ExtentReports extent;
	
	 public static ExtentReports getExtentReports() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("chefhero Automation Results");
		reporter.config().setDocumentTitle("Extent Reports ");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rakesh");
		return extent;
	}

}
