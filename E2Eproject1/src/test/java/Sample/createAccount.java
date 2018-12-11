package Sample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.SignUpPage;
import resources.base;

public class createAccount extends base{
	public static Logger log=LogManager.getLogger(createAccount.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateSignUpPageTitle() throws IOException
	{
		LoginPage l=new LoginPage(driver);
		l.getSignUpText().click();
		SignUpPage s=new SignUpPage(driver);
		Assert.assertEquals(s.getTitle().getText(),"Create Account");
		log.info("Successfully navigated to Sign Up page");
	}
	
	@Test
	public void validateSearchFieldText()
	{
		LoginPage l=new LoginPage(driver);
		l.getSignUpText().click();
		SignUpPage s=new SignUpPage(driver);
		Assert.assertEquals(s.getsearchbardefaultText().getAttribute("placeholder"), "Find Your Institution");
		log.info("'Find Your Institution' text in search found");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null; //release memory for driver object
	}
}
