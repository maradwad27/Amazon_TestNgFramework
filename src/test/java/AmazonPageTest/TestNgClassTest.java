package AmazonPageTest;

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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgClassTest {
	 @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("Before Suite");
	    }

	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("After Suite");
	    }

	    @BeforeTest
	    public void beforeTest() {
	        System.out.println("Before Test");
	    }

	    @AfterTest
	    public void afterTest() {
	        System.out.println("After Test");
	    }

	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before Class");
	    }

	    @AfterClass
	    public void afterClass() {
	        System.out.println("After Class");
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Before Method");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("After Method");
	    }

	    @BeforeGroups("group1")
	    public void beforeGroups() {
	        System.out.println("Before Group1");
	    }

	    @AfterGroups("group1")
	    public void afterGroups() {
	        System.out.println("After Group1");
	    }

	    @Test(groups = "group1")
	    public void testCase1() {
	        System.out.println("Test Case 1 in Group1");
	    }

	    @Test
	    public void testCase2() {
	        System.out.println("Test Case 2");
	    }

	    @DataProvider(name = "dataProviderExample")
	    public Object[][] dataProviderMethod() {
	        return new Object[][] { { "data1" }, { "data2" } };
	    }

	    @Test(dataProvider = "dataProviderExample")
	    public void testWithData(String data) {
	        System.out.println("Test with Data: " + data);
	    }

	    @Parameters({"param1"})
	    @Test
	    public void testWithParameter(@Optional("defaultValue") String param1){
	        System.out.println("Test with Parameter: " + param1);
	    }
}
