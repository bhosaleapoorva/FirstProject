package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	public static ExtentReports getReportObject()   //made it as static so that no object needs to be created.
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";  //location where the report is to be kept.
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation Results");   //report name is set
		reporter.config().setDocumentTitle("Test Results");  //document title is set
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rahul Shetty");    //tester name is set.
		return extent;
		
		
		
	}

}
