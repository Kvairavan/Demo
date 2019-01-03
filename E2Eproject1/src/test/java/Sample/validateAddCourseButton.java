package Sample;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.LoginPage;
import resources.base;

public class validateAddCourseButton extends base{
	
	public static Logger log=LogManager.getLogger(validateAddCourseButton.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	@Test(dataProvider="getData")
	public void validateAddCourseButton(String email,String pwd) throws InterruptedException
	{
		LoginPage l= new LoginPage(driver);
		CoursesPage c=new CoursesPage(driver);
		l.getEmail().sendKeys(email);
		l.getPasword().sendKeys(pwd);
		l.getLogin().click();
		Thread.sleep(3000);
		c.add_a_course().click();
		Assert.assertEquals(driver.getTitle(), "Reef Add Course - Find Your Institution");
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		driver=null;
		log.info("Browser Closed");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="kstudent@reef-education.com";
		data[0][1]="12345678";
		return data;
	}
}
