package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;


//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base {
	public static WebDriver driver; // static requires driver object to become null at the end of each test
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream file= new FileInputStream("//Users//ksaravanan//Documents//Selenium2018//E2Eproject//src//main//java//resources//data.properties");
		prop.load(file);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.equals("chrome"))
		{
			//Excecute in chrome
			System.setProperty("webdriver.chrome.driver", "//Users/ksaravanan//Documents//Selenium2018//chromedriver");
			driver=new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			//Execute in firefox
			System.setProperty("webdriver.gecko.driver", "//Users//ksaravanan//Documents//Selenium2018//geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("safari"))
		{
			//Execute in safari
			System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
			driver = new SafariDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("//Users//ksaravanan//Documents//Selenium2018//Screenshots//"+result+"screenshot.png"));// add dependency in POM for apache.commons.io from mvn repository
	
	}
}
