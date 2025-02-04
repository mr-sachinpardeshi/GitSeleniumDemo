package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utility.Utilities;

public class LoginPage extends Utilities {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id = "nav-link-accountList-nav-line-1" )
	WebElement signInButton;
	
	@FindBy(xpath = "//input[contains(@type,'email')]")
	WebElement inputTextBox;
		
	@FindBy(id = "continue")
	WebElement continueBttn;
	
	@FindBy(xpath = "//div[@id='invalid-phone-alert']/div/div")
	WebElement invalidContactNo;
	
	@FindBy(xpath = "//div[@id='empty-claim-alert']/div/div")
	WebElement blankTextErrorMsg;
	
	@FindBy(xpath = "//div[@id = 'error-alert']/div/div")
	WebElement errorAlert;
	
	@FindBy(xpath = "//div[@id = 'passkey-error-alert']/div/div")
	WebElement passkeyErrorAlert;
	
	@FindBy(xpath = "//div[@id = 'invalid-email-alert']/div/div")
	WebElement invalidEmailErrMsg;
	
	@FindBy(xpath = "//div[@class = 'a-alert-content']/ul/li/span")
	WebElement alertContent;
	
	@FindBy(xpath = "//div[@id = 'auth-email-invalid-claim-alert']/div/div")
	WebElement invalidEmailOrMob;
	
	public void loginTest(String details) throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(signInButton).click().perform();
		WebElement inputField;
		  inputField = inputTextBox;
	
		inputField.sendKeys(details);
		continueBttn.click();
		Thread.sleep(1000);
	}
	
	public String validateErrorMessages() {
		List <WebElement> errorLocators = new ArrayList<>();
		errorLocators.add(invalidContactNo);
		errorLocators.add(blankTextErrorMsg);
		errorLocators.add(errorAlert);
		errorLocators.add(passkeyErrorAlert);
		errorLocators.add(invalidEmailErrMsg);
		errorLocators.add(alertContent);
		errorLocators.add(invalidEmailOrMob);
		
		 for (WebElement locator : errorLocators) {
	            try {
	                if (locator.isDisplayed()) {
	                	//System.out.println("Login Page"+locator.getText());
	                    return locator.getText();
	                }
	            } catch (NoSuchElementException e) {
	                // Element not found, continue to the next locator
	            }
	        }

	        return "No error message found.";
	    }
		
	
//	public String loginErrorMsgEmail() {
//		waitForWebElementToAppear(invalidEmailErrMsg);
//		String errMsg = invalidEmailErrMsg.getText();
//		return errMsg;
//	}
//	public String loginErrorMsgContact() {
//		waitForWebElementToAppear(invalidContactNo);
//		String errMsg = invalidContactNo.getText();
//		return errMsg;
//	}
//	public String loginWithoutText() {
//		waitForWebElementToAppear(blankTextErrorMsg);
//		String errMsg = blankTextErrorMsg.getText();
//		return errMsg;
//		
//	}
	
}
