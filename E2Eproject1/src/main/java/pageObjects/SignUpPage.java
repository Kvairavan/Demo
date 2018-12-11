package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
	WebDriver driver;
	By title=By.xpath("//div[@id='wrapper']/div/h1"); // "Create Account" title
	By searchbar=By.xpath("//input[@placeholder='Find Your Institution']"); // search bar placeholder text
	
		public SignUpPage(WebDriver driver)
		{
			this.driver=driver;
		}
	
		public WebElement getTitle()
		{
			return driver.findElement(title);
		}
		public WebElement getsearchbardefaultText()
		{
			return driver.findElement(searchbar);
		}
}
