package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursesPage {
	
	public WebDriver driver;
	By title=By.xpath("//*[@id='wrapper']/div[1]/h1"); //Courses object on Course List
	
	public CoursesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver; //this block gives life to driver object in this class
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
}
