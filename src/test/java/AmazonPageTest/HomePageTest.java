package AmazonPageTest;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.ExcelReader;

@Listeners(AmazonPageTest.TestNGListener.class)
public class HomePageTest extends BaseTest {
	@FindBy(xpath = "//span[text()='Sign in']")
	WebElement btnSingIN;

	@BeforeMethod
	public void readLocator() throws IOException {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\UtilityData\\TestData.xlsx";
		ExcelReader.ReadRow(filePath, "SignUpPage");
	}

	@BeforeClass
	public void initalizeElement() {
		PageFactory.initElements(driver, this);
	}
//Verify page Title
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void VerifyTitlePage() throws InterruptedException {
		driver.navigate().to("https://www.amazon.in/");
		driver.navigate().refresh();
		Thread.sleep(4);
		String title = driver.getTitle();
		Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", title);
				 
	}

	@Test(groups = "SignIn")

	public void navigateToSignUpPage() {
		Actions actions = new Actions(driver);
		WebElement btnAccountList = driver.findElement(ExcelReader.rowOutput(1));
		actions.moveToElement(btnAccountList).build().perform();
		btnSingIN.click();
	}

}
