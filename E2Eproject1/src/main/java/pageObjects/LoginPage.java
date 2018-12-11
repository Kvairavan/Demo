package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	//Define Objects at the top--Best practise
	
	By email=By.cssSelector("[id='userEmail']");
	By password=By.id("userPassword");
	By signin=By.id("sign-in-button");
	By title=By.cssSelector("label.login-page-text");
	By signup=By.xpath("//a[text()='Sign Up!']");
	By forgotpassword=By.linkText("Forgot Password?"); 
	
	//Define methods at the bottom of Page Object --Best practise in designing page object model
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver; //this block gives life to driver object in this class
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPasword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(signin); //object should be segregated from driver.findElement
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getForgotPasswordLink()
	{
		return driver.findElement(forgotpassword);
	}
	public WebElement getSignUpText()
	{
		return driver.findElement(signup);
	}
}
