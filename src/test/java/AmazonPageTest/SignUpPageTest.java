package AmazonPageTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.ExcelReader;
@Listeners(AmazonPageTest.TestNGListener.class)
public class SignUpPageTest extends BaseTest{
	WebDriverWait wait;
	Actions action;
	@FindBy(id="ap_email_login")
	WebElement txtEmail;
	
	@FindBy(id="continue")
	WebElement btnContinue;
	
	@FindBy(id="ap_password")
	WebElement txtPassword;
	
	@FindBy(xpath="//span[@id='auth-signin-button-announce']")
	WebElement btnSignIn;
	@BeforeClass
	public void waitToElementLoad()
	{
		 wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 action=new Actions(driver);
	}
	@BeforeClass
	public void initalizeElement()
	{
		PageFactory.initElements(driver, this);
	}
	@Test(dependsOnMethods = "AmazonPageTest.HomePageTest.navigateToSignUpPage",priority = 1)
	public void LoginToWebsite() throws InterruptedException
	{
		txtEmail.sendKeys("madhuriaradwad27@gmail.com");
		btnContinue.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		txtPassword.sendKeys("Madhuri@27");
		wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
		action.moveToElement(btnSignIn).click();
		
		
	}
	

}
