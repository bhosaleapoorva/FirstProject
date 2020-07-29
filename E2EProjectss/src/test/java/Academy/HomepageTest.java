package Academy;

import org.testng.annotations.Test;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Landingpage;
import pageobjects.Login;
import resources.Basefile;

public class HomepageTest extends Basefile{
    WebDriver d;               //local driver is initialised so that the main driver from the basefile is not overridden again and again.
	public static Logger Log=LogManager.getLogger(HomepageTest.class.getName());
	
	
	@BeforeTest
    public void Initialize() throws IOException
{
	   d= InitializeDriver();             //d from initialiseddriver is assigned to d here in local.
	   Log.info("Driver is initialized");
	   
}
	
	
	
	@Test(dataProvider="getData")
	
	public void HomeLogin(String email,String password) throws IOException
	{

	    d.get(prop.getProperty("url"));

    Landingpage l=new Landingpage(d);     //object of the page object java class to access its methods and objects.
    Login lp=new Login(d);                                 //there was no life to the driver in Landingpage class. So passing driver as argument in its obj. Now
                                         // a constructor is made in LandingPage class which threby gives life to the driver in that class.
//   l.PopUp().click();
    l.getLogin().click();
  
    lp.Email().sendKeys(email);
    lp.Password().sendKeys(password);
    lp.loginButton().click();
	   Log.info("Login button is clicked");

	}
	
	@AfterTest
	public void TearDown()
	{
		d.close();
	}     
	
    @DataProvider
    public Object[][] getData()
    {
    	//Rows tells us how many types of data..like invalid and valida combination like that.
    	//Column tells us the no data in each types-like valid name,pwd,etc.
    	//here there are 2 types of data but indexing starts from 0.so 1 is given.
    	Object data[][]=new Object[2][2];// 2 data were there.i.e 0 and 1
    	data [0][0]="hello@gmail.com";//email
    	data [0][1]="sendkeyseverywhere";//pwd
    	
    	data [1][0]="why@gmail.com";//email
    	data [1][1]="nonnfgfseverywhere";//pwd	
    	
    	return data;
    }
}


