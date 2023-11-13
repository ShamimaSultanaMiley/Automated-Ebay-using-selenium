package base;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public static WebDriver driver;

	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "J:\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		// below code is for to remove " chrome is controlled by automated software" we
		// have to make the Extension false
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.setPageLoadTimeout(Duration.ofSeconds(30));
		options.setScriptTimeout(Duration.ofSeconds(30));

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

	}

	public static void navigateTo(String url) {
		driver.get(url);

	}

	public static void click(By by) {
		driver.findElement(by).click();
	}

	public static void sendKeys(By by, String searchTag) {

		driver.findElement(by).sendKeys(searchTag);
	}

}
