package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Basefile;
import resources.ExtentReporterNG;

public class Listeners extends Basefile implements ITestListener {

	ExtentTest test;
	ExtentReports extent1=	ExtentReporterNG.getReportObject();//gets the extent variable.Store it in a dummy variable.
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>(); //java makes the instances of ExtentTest,threadsafe.
    
     
	@Override
	public void onTestStart(ITestResult result)  //This ensures to run the code before every test.
	{
		ITestListener.super.onTestStart(result);
		test=extent1.createTest(result.getMethod().getMethodName()); //test is the extent object responsible for reporting.
		
		//so like this instead of writing the entire code for reports before every test,we write it in a listener method and take reference of Extent Report class files also.
	extentTest.set(test);   //Now on every TestStart,the particular class's object via test gets stored in a pool using extentTest.	
	
	}

	
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Successful");  //extentTest.get helps to fetch the objects as per class wise on runtime.
	}

	
	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());   // we can see all the failure logs.//.get function tells extenttest to fetch that particular class files objects.
		WebDriver d1=null;  //define the dummy driver in this method which does not have a life here.
		
		String methodname=result.getMethod().getMethodName();  //taking the name of the method to identify which test got failed.
		ITestListener.super.onTestFailure(result);
		
		try {
			d1=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("d").get(result.getInstance());//d1 gets a life here.
		
		}
	    catch (Exception e1) {
			e1.printStackTrace();
		}

		
		try {
			extentTest.get().addScreenCaptureFromPath(ScreenShot(methodname,d1), result.getMethod().getMethodName());// added the screenshot method return value and name of the screenshot.
		//	ScreenShot(methodname,d1);  //connect the driver over here.Same is passed in the ScreenShot method also.
		}
		catch(IOException e)
		{
			
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	
	
	
	@Override
	public void onFinish(ITestContext context) {

	extent1.flush();
	}

}
