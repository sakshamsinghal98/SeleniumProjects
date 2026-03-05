package com.framework.base;

import com.framework.utils.configReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

	public static void validateLinks(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		log.info("Total links found: " + links.size());

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			System.out.println(url);
			if (url != null && !url.isEmpty()) {
				try {
					HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
					connection.setRequestMethod("HEAD");
					connection.connect();
					int responseCode = connection.getResponseCode();
					if (responseCode >= 400) {
						log.error("Broken link: " + url + " - Response: " + responseCode);
					} else {
						log.info("Valid link: " + url + " - Response: " + responseCode);
					}
				} catch (Exception e) {
					log.error("Error checking link: " + url);
				}
			}
		}
	}

	public static void switchToNewTab(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		Iterator<String> it = child.iterator();

		while (it.hasNext()) {

			String window = it.next();

			if (!window.equals(driver.getWindowHandle())) {
				driver.switchTo().window(window);
				break;
			}

		}
	}

}