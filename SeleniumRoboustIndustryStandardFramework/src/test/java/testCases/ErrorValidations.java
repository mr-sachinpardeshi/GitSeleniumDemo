package testCases;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import baseClass.BaseClass;
import baseClass.Retry;
import pageObjects.LoginPage;

public class ErrorValidations extends BaseClass {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		driver = getDriver();
	}
	
	@Test (groups = {"ErrorHandling"}, dataProvider = "getData", retryAnalyzer=Retry.class)
	public void validateAllErrorMessages(HashMap<String, String> input) throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.loginTest(input.get("loginData"));
		//System.out.println(lp.validateErrorMessages());
		
		String actualMessage = lp.validateErrorMessages();
		//System.out.println(actualMessage);
		List<String> expectedMessages = Arrays.asList("Invalid mobile number", "We cannot find an account with that mobile number", "Enter your mobile number or email","Invalid email address.","Something is not right. Try again.","Wrong or Invalid email address or mobile phone number. Please correct and try again.");
		Assert.assertTrue(expectedMessages.contains(actualMessage));
	}
	
	
//	@Test (groups = {"ErrorHandling"}, dataProvider = "getData")
//	public void loginInvalidContactNo(HashMap<String, String> input) throws InterruptedException {
//		LoginPage lp = new LoginPage(driver);
//		lp.loginTest(input.get("contactNo"));
//		Assert.assertEquals(lp.loginErrorMsgContact(), "Invalid mobile numbers"); //failing test case adding 's'
//	}
//	
//	@Test (priority = 1, groups = {"Error Handling"}, dataProvider = "getData")
//	public void loginInvalidEmailId(HashMap<String, String> input) throws InterruptedException {
//		LoginPage lp = new LoginPage(driver);
//		lp.loginTest(input.get("emailId"));
//		Assert.assertEquals(lp.loginErrorMsgEmail(), "Invalid email address.");
//		//Assert.assertEquals(lp.loginErrorMsg(), "Incorrect phone number\r\n"
//		//		+ "We cannot find an account with that mobile number");
//	}
	
	@DataProvider
	public Object[][] getData() throws JsonProcessingException, Exception {
		//return new Object[][] {{"343224","sadsdf"},{"5657565","werwe"},{"345345" ,"erwere"}};
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("contactNo","345345");
//		map.put("emailId", "rrwety");
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("contactNo","345345");
//		map1.put("emailId", "eewewr");
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("contactNo","345345");
//		map2.put("emailId", "sdfwer");
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//loginInvalidTestData.json");
		
		
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)},{data.get(5)},{data.get(6)},{data.get(7)},{data.get(8)},{data.get(9)}};
	}
	
}
