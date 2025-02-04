package stepDefinations;

	import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import baseClass.BaseClass;
	import io.cucumber.java.en.*;
	import pageObjects.HomePage;
	import pageObjects.ProductCataloguePage;
	import pageObjects.ShoppingCartPage;

	public class AmazonOrder extends BaseClass {
	    WebDriver driver;
	    HomePage homePage;
	    ProductCataloguePage productCataloguePage;
	    ShoppingCartPage shoppingCartPage;
	    String productName = "Parker Frontier Matte Black Gold Trim Roller Ball Pen| Ink Color - Blue | Perfect For Employees | Unique Gifts For Entrepreneurs";

	    public AmazonOrder() throws Exception {
	        initializeDriver();  // Ensures driver is initialized before tests run
	        this.driver = getDriver();
	        homePage = new HomePage(driver);
	        productCataloguePage = new ProductCataloguePage(driver);
	        shoppingCartPage = new ShoppingCartPage(driver);
	    }

	    @Given("User is on the Amazon homepage")
	    public void user_is_on_the_amazon_homepage() throws Exception {
	        launchTheApplication();
	    }

	    @When("User searches for {string}")
	    public void user_searches_for(String product) {
	        homePage.searchProduct(product);
	    }

	    @When("User adds the product {string} to the cart")
	    public void user_adds_the_product_to_the_cart(String product) throws InterruptedException {
	        productCataloguePage.addProduct(product);
	    }

	    @Then("The cart should contain {int} item")
	    public void the_cart_should_contain_item(Integer expectedItemCount) throws Exception {
	        String actualItemCount = productCataloguePage.cartDetails();
	        Assert.assertEquals(expectedItemCount.toString(), actualItemCount);
	    }

	    @Then("The cart should display the correct product name")
	    public void the_cart_should_display_the_correct_product_name() {
	        Assert.assertEquals(shoppingCartPage.validateProductsInCart(), productName);
	    }

	    @When("User proceeds to checkout")
	    public void user_proceeds_to_checkout() {
	        shoppingCartPage.ProceedToBuyButton();
	    }

	    @Then("User should be on the checkout page")
	    public void user_should_be_on_the_checkout_page() {
	        // You can add a validation to check if the checkout page is displayed
	    }

	    @When("User searches for a product")
	    public void user_searches_for_a_product() {
	        homePage.searchProduct("pen");
	    }

	    @Then("Search results should be displayed")
	    public void search_results_should_be_displayed() {
	        // Validate that search results appear
	    }
	

}
