package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utilities;

public class ShoppingCartPage extends Utilities{
	WebDriver driver;
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".a-truncate-cut")
	WebElement productsInCart;
	
	@FindBy(xpath = "//div[@class='sc-without-multicart']/ancestor::span/span/span/span/div/div")
	WebElement proceedToBuyButton;
	
	public String validateProductsInCart() {
		return(productsInCart.getText());
	}
	
	public void ProceedToBuyButton() {
		actionClick(proceedToBuyButton);
	}
}
