package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseClass {
	public WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass(alwaysRun = true)
	public void initializeDriver() throws InterruptedException, Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//resournces//GlobalData.properties");
		prop.load(fis);
		// can control browser selection from maven. -> mvn test -PRegression
		// -Dbrowser=firefox
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			if (browserName.contains("headless")) {
				driver = new ChromeDriver(options);
			}
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1440,900)); //to maximize if it is headless mode, if any element not visible
		} else if (browserName.equalsIgnoreCase("fireFox")) {
			// firefox
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.35.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// firefox
		}

	}

	@BeforeMethod(alwaysRun = true)
	public void launchTheApplication() throws Exception {
		driver.get("https://www.amazon.in/");
		Thread.sleep(4000);
		driver.manage().window().maximize(); //may not give good effect when we run in headless mode. In the browser.
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws Exception, JsonProcessingException {
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		// String to hashMap - jackson data bind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		// return System.getProperty("user.dir") + "//reports//" + testCaseName +
		// ".png";
		return file.getAbsolutePath();
	}

}
