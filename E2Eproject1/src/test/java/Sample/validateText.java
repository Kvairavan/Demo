package Sample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.LoginPage;
import resources.base;

public class validateText extends base {
	public static Logger log=LogManager.getLogger(validateText.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Reef Home page");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		LoginPage l=new LoginPage(driver);
		//Compare course title with expected
		Assert.assertEquals("Don't have an account?", l.getTitle().getText());
		log.info("Successfully found 'Dont't have an account' text");
	}
	@Test
	public void validateForgotPasswordLink() throws InterruptedException
	{
		LoginPage l=new LoginPage(driver);
		l.getForgotPasswordLink().click();
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> it=windowIds.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		String resetpwdurl=driver.getCurrentUrl();
		Assert.assertEquals(resetpwdurl, "https://admin-dev.reef-education.com/account/password-reset");
		log.info("Successfully navigated to Reset Password page");
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.switchTo().defaultContent();
		driver.quit();
		log.info("Browser Closed");
		driver=null; //release memory for driver object
	}

}
