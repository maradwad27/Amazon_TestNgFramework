package AmazonPageTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

public class TestNGListener implements ITestListener {
	WebDriver driver;

	@Override
	public void onFinish(ITestContext contextFinish) {
		System.out.println("onFinish method finished");

	}

	@Override
	public void onStart(ITestContext contextStart) {
		System.out.println("onStart method started");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Method failed with certain success percentage" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Method failed" + result.getName());
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();
		TakesScreenshot srcshot = ((TakesScreenshot) driver);
		File srcfile = srcshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("C:\\Users\\Admin\\eclipse-workspace\\AmazonAutomation\\Screenshots\\"+result.getName()+".jpg");
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Method skipped" + result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Method started" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Method passed" + result.getName());

	}
}
