package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursesPage {
	
	public WebDriver driver;
	By title=By.xpath("//*[@id='wrapper']/div[1]/h1"); //Courses text on Course List
	By add_course_button=By.xpath("//*[@id='courses-page']/div[1]/div[1]/div[2]/button");
	
	public CoursesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver; //this block gives life to driver object in this class
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement add_a_course()
	{
		return driver.findElement(add_course_button);
	}
	
}
