package AmazonPageTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int count=0;
	private static final int maxTry=3;
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

}
