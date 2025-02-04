package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utilities;

public class HomePage extends Utilities {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("pen");
//	driver.findElement(By.id("nav-search-submit-button")).click();
	
	@FindBy(css = "input#twotabsearchtextbox" )
	WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;
	
	public ProductCataloguePage searchProduct(String product) {
		searchBox.sendKeys(product);
		searchButton.click();
		ProductCataloguePage pc = new ProductCataloguePage(driver);
		return pc;
	}
	
	public void goTo() {
		
	}
}
