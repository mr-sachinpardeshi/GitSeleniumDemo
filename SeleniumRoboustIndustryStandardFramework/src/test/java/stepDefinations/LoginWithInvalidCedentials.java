package stepDefinations;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginWithInvalidCedentials extends BaseClass {
	WebDriver driver;
	LoginPage lp;

	public LoginWithInvalidCedentials() throws InterruptedException, Exception {
		initializeDriver(); // Ensure driver is initialized before tests run
		this.driver = getDriver();
		lp = new LoginPage(driver);
	}

	@Given("Landed on Amazon Website")
	public void landed_on_amazon_website() throws Exception {
		launchTheApplication();
	}

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		lp = new LoginPage(driver);
	}

	@When("User enters {string} and submits")
	public void user_enters_and_submits(String loginData) throws Exception {
		lp.loginTest(loginData);
	}

	@Then("User should see an appropriate error message")
	public void user_should_see_an_appropriate_error_message() {
		String actualMessage = lp.validateErrorMessages();
		List<String> expectedMessages = Arrays.asList("Invalid mobile number",
				"We cannot find an account with that mobile number", "Enter your mobile number or email",
				"Invalid email address.", "Something is not right. Try again.",
				"Wrong or Invalid email address or mobile phone number. Please correct and try again.");

		Assert.assertTrue(expectedMessages.contains(actualMessage));
		driver.quit();
	}

}
