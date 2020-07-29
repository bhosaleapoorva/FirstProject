package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

	
	public WebDriver d;
	
By email=By.cssSelector("[id='user_email']");
By password=By.cssSelector("[type='password']");
//By loginbutton=By.cssSelector("input[class='btn btn-primary btn-md login-button']");



By loginbutton=By.cssSelector("[value='Log In']");

public Login(WebDriver d) {
	// TODO Auto-generated constructor stub
	this.d=d;    //d2 has life from Homepage class which gives life to d in this class.
	
}



public WebElement Email()
{
	return d.findElement(email);
	
}
public WebElement Password()
{
	return d.findElement(password);
}
public WebElement loginButton()
{
	return d.findElement(loginbutton);
}

}
