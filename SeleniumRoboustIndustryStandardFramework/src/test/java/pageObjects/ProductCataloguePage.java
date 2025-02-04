package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Utilities;

public class ProductCataloguePage extends Utilities {

	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".sg-col-4-of-12")
	WebElement listOfProducts;

	@FindBy(css = ".s-result-item.s-asin")
	List<WebElement> productss;
	
	@FindBy(id = "nav-cart-count-container")
	WebElement productInCart;
	

//	@FindBy(css = ".a-size-base-plus span")
//	WebElement productOnPage;
//
//	@FindBy(css = ".puis-atcb-add-container button")
//	WebElement addToCartPage;
	By productOnPageBy = By.cssSelector(".a-size-base-plus span");
	By addToCartPageBy = By.cssSelector(".puis-atcb-add-container button");
	By productsBy = By.cssSelector(".sg-col-4-of-12");
	By ByproductInCart = By.id("nav-cart-count-container");
	
	public void addProduct(String productName) {
		waitForElementToAppear(productsBy);
		List<WebElement> products = productss;
		for (WebElement p : products) {
			if (p.findElement(productOnPageBy).getText().equals(productName)) {
				p.findElement(addToCartPageBy).click();
				break;
			}

		}
	}
	
	public String cartDetails() throws InterruptedException {
		Thread.sleep(4000);
		waitForElementToAppear(ByproductInCart);
		String totalProd = productInCart.getText();
		productInCart.click();
		return totalProd;
		
	}
	
}
