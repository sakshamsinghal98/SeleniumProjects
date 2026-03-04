package com.framework.base;

import com.framework.utils.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	private static final Logger log = LogManager.getLogger(BaseClass.class);
	public static WebDriver driver;

	public static void launchBrowser() {
		log.info("Launching browser...");
		String browser = configReader.get("browser");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.get(configReader.get("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Browser launched successfully!");

	}

	public static void closeBrowser() {
		log.info("Closing browser...");

		if (driver != null) {
			driver.quit();
		}
		log.info("Browser closed successfully!");

	}

	public static void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}