package Sample;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
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
		log.info("Navigated to Add Course page");
		driver.navigate().back();
	}
	@Test
	public void validateSelectCourse() throws InterruptedException
	{
		
		CoursesPage c=new CoursesPage(driver);
		Thread.sleep(3000);
		for (WebElement E:c.get_course_list())
		{
			//System.out.println(E.getAttribute("innerHTML"));
			if (E.getAttribute("innerHTML").contains("Creating a course"))
			{
				E.click();
				log.info("Found course 'Creating a course' in active course list");
				Assert.assertEquals(c.coursepage().getText(), "Creating a course");
				break;
			}
			
		}
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
