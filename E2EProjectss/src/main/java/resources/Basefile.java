package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Basefile {

	private WebDriver d;
	public Properties prop;    //defined it outside for a public access.
	
	
	public WebDriver InitializeDriver() throws IOException
	{
		//I have built a smartscript that can handle any browser as per need. 
		//Relevant methods are made to invoke these browsers.
	prop=new Properties();   //define it outside
	
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\resources\\Data.properties"); //set the path of the external global variable file.
	prop.load(fis);                                 //connecting prop with fis.
	String browserName=prop.getProperty("browser"); //pulls the value of browser variable from the global text file. We are storing it in a variable.
//	String browserName=System.getProperty("browser");   to choose a browser from maven cmd.
	
	
	
	if(browserName.contains("chrome"))
	{
		ChromeOptions options=new ChromeOptions();

		if(browserName.contains("headless"))        //if it contains headless,then it will move inside.
		{
			options.addArguments("headless");
		}
		System.setProperty("webdriver.chrome.driver", "D:\\IT\\Softwares\\chromedriver.exe");
		
		d=new ChromeDriver(options);               //if no headless,then null will be passed which will let you run in head mode.
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "D:\\IT\\Softwares\\chromedriver.exe");
		d=new FirefoxDriver();

	}
	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", "D:\\IT\\Softwares\\IEDriver.exe");
	    d=new InternetExplorerDriver();

	}
	
	
	d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return d;

	
	
	}
	
	
	
	
	
	
	
	
	
	public String ScreenShot(String testcasename,WebDriver d) throws IOException   //testcasename is actually the failed method name that we will give to the SS.
	{
		TakesScreenshot ts=(TakesScreenshot)d;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destfile=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";   //you have provided a path to store the SS.user.dir is the main project directory
		FileUtils.copyFile(source,new File(destfile));    //here the source id a virtual source. So it gets copied from source to given destination.
	return destfile;
	}
}



