package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursesPage {
	
	public WebDriver driver;
	By title=By.xpath("//*[@id='wrapper']/div[1]/h1"); //Courses text on Course List
	By add_course_button=By.xpath("//*[@id='courses-page']/div[1]/div[1]/div[2]/button");
	By courselist=By.xpath("//li[@class='ng-scope']"); //active courses
	By coursepage=By.xpath("//div[@id='course-screen']/div[1]/nav-bar/div[1]/h1");
	
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
	public List<WebElement> get_course_list()
	{
		return driver.findElements(courselist); //return a list of webelements
	}
	public WebElement coursepage()
	{
		return driver.findElement(coursepage);
	}
	
}
