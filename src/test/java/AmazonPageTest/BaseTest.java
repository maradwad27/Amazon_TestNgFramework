package AmazonPageTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utility.ExcelReader;

public class BaseTest {

	public static WebDriver driver;
	
	@BeforeSuite
	public void initializer() throws IOException {
		
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.drive",
					System.getProperty("user.dir") + "\\AmazonAutomation\\src\\test\\resources\\BrowserDrivers\\chromedriver.exe");
			driver.manage().window().maximize();

	}
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	public WebDriver getDriver()
	{
		return driver;
	}

}
