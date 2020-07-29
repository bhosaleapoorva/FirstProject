package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Landingpage;
import resources.Basefile;



public class ValidateTitleTest extends Basefile {
	WebDriver d;
	public static Logger Log=LogManager.getLogger(ValidateTitleTest.class.getName());
	
	@BeforeTest
    public void Initialize() throws IOException
{
	   d= InitializeDriver();
	    d.get(prop.getProperty("url"));
}
	@Test()
	public void ValidateTitle() throws IOException
	{
 
    Landingpage l=new Landingpage(d);     //object of the page object java class to access its methods and objects.
  Assert.assertEquals(l.Title().getText(), "FEATUR COURSES");                                     
    Log.info("Successfully Checked the title");
	}
	
	
	@AfterTest
	public void TearDown()
	{
		d.close();
	}
}
