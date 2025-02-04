package selenium;


import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAlonetest {
	public static void main(String[] args) throws Exception {
	//WebDriverManager.chromedriver().setup();
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	Thread.sleep(10000);
	String productName = "Parker Frontier Matte Black Gold Trim Roller Ball Pen| Ink Color - Blue | Perfect For Employees | Unique Gifts For Entrepreneurs";
	driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("pen");
	driver.findElement(By.id("nav-search-submit-button")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sg-col-4-of-12")));
	List <WebElement> products = driver.findElements(By.cssSelector(".s-result-item.s-asin"));
	
//	WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("h2")).equals("Reynolds AEROSLIM Ball Pen SET - 50 BLUE PENS WITH COMFORTABLE GRIP |BLUE BALL PENS FOR WRITING | PEN FOR STUDENTS & OFFICE STATIONERY | 0.7 mm TIP SIZE")).findFirst().orElse(null);
//	System.out.println(prod);
//	prod.findElement(By.cssSelector(".puis-atcb-add-container button")).click();
	System.out.println("iN FOR LOOP");
	for(WebElement p: products) {
		if(p.findElement(By.cssSelector(".a-size-base-plus span")).getText().equals(productName)) {
			p.findElement(By.cssSelector(".puis-atcb-add-container button")).click();
			break;
		}
		
	}

	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-global-location-toaster-script-container")));
	
	Thread.sleep(4000);
	System.out.println("Count is: "+driver.findElement(By.id("nav-cart-count-container")).getText());
	driver.findElement(By.id("nav-cart-count-container")).click();
	System.out.println(driver.getCurrentUrl());
	String AddCartProduct = driver.findElement(By.cssSelector(".a-truncate-cut")).getText();
	System.out.println(AddCartProduct);
	Assert.assertEquals(productName,AddCartProduct);
	WebElement buyButton = driver.findElement(By.xpath("//div[@class='sc-without-multicart']/ancestor::span/span/span/span/div/div"));
	Actions act = new Actions(driver);
	act.moveToElement(buyButton).click().build().perform();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sc-without-multicart']/ancestor::span/span/span/span/div/div"))).click();
	System.out.println("Execution reached till this");
	Thread.sleep(2000);
	
}
}