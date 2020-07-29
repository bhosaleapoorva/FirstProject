package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Landingpage;
import resources.Basefile;



public class NavigationBarTest extends Basefile {
	
	WebDriver d;    //local driver is initialised so that the main driver from the basefile is not overridden again and again.
	public static Logger Log=LogManager.getLogger(NavigationBarTest.class.getName());

	
	
	@BeforeTest
    public void Initialize() throws IOException
{
	   d= InitializeDriver();   //d from initialiseddriver is assigned to d1.
	    d.get(prop.getProperty("url"));
}

	
	
	
	public void basePageNavigation() throws IOException
	{
    
    Landingpage l=new Landingpage(d);     //object of the page object java class to access its methods and objects.
    AssertJUnit.assertTrue(l.NavigationBar().isDisplayed());
    Log.info("Navigation details are checked.");
	}
	
	
	@AfterTest
	public void TearDown()
	{
		d.close();
	}
}
