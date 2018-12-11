package Sample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.LoginPage;
import resources.base;

public class LoginScreen extends base {
	/*@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	}*/
	
		
	@Test(dataProvider="getData")
	
	public void validateLogin(String email, String pwd) throws IOException, InterruptedException
	{
	driver=initializeDriver();
	driver.get(prop.getProperty("url"));
	LoginPage l=new LoginPage(driver);
	CoursesPage c=new CoursesPage(driver);
	l.getEmail().sendKeys(email);
	l.getPasword().sendKeys(pwd);
	l.getLogin().click();
	//Thread.sleep(3000);
	//Assert.assertEquals("Courses", c.getTitle().getText()); //Verifies successful login
	Assert.assertTrue(c.getTitle().isDisplayed());
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null; //release memory for driver object
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];//1=no of test, 2=values per test object[row][col] row= how many tests should run, col=how many values per test
		data[0][0]="kstudent@reef-education.com";
		data[0][1]="12345678";
		data[1][0]="kstudent1@reef-education.com";
		data[1][1]="12345678";
		return data;
		
		
	}

}
