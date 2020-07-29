package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Landingpage {

	
	public WebDriver d;
	
By signin=By.cssSelector("a[href*='sign_in']");
By title=By.cssSelector("div[class='text-center']");
By Navigationbar=By.cssSelector("ul[class='nav navbar-nav navbar-right']");
By Popup=By.xpath("//*[text()='NO THANKS']");

@FindBy(xpath="//*[text()='NO THANKS']")
WebElement xpathy;

public Landingpage(WebDriver d) {
	// TODO Auto-generated constructor stub
	this.d=d;    //d2 has life from Homepage class which gives life to d in this class.
	
}



public WebElement getLogin()
{
	return d.findElement(signin);
	
}

public WebElement Title()
{
	return d.findElement(title);
}

public WebElement NavigationBar()
{
	return d.findElement(Navigationbar);
}
public WebElement PopUp()
{
	return d.findElement(Popup);
}



}
