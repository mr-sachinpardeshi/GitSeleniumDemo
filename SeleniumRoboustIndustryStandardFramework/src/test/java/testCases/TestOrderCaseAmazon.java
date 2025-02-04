package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.ProductCataloguePage;
import pageObjects.ShoppingCartPage;

public class TestOrderCaseAmazon extends BaseClass {

WebDriver driver;
String productName = "Parker Frontier Matte Black Gold Trim Roller Ball Pen| Ink Color - Blue | Perfect For Employees | Unique Gifts For Entrepreneurs";
@BeforeClass
public void beforeClass() {
	driver = getDriver();
}
@Test
public void test() throws InterruptedException {
	HomePage homePage = new HomePage(driver);
	homePage.searchProduct("pen");
	ProductCataloguePage pc = new ProductCataloguePage(driver);
	pc.addProduct(productName);
	String noOfProd = pc.cartDetails();
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertEquals(noOfProd,"1");
	ShoppingCartPage pg = new ShoppingCartPage(driver);
	Assert.assertEquals(pg.validateProductsInCart(), productName);
	pg.ProceedToBuyButton();
	softAssert.assertAll();
}
@Test(dependsOnMethods = {"test"})
public void searchProduct() {
	
	
}
}
