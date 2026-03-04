package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.base.BaseClass;

import java.time.Duration;

public class HomePage {

	WebDriver driver;

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;

	@FindBy(id = "nav-logo-sprites")
	WebElement amazonLogo;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchProduct(String productName) {
		BaseClass.waitForElement(searchBox);
		searchBox.sendKeys(productName);
		searchButton.click();
	}

	public void checkAmazonLogo() {
		BaseClass.waitForElement(amazonLogo);
		amazonLogo.isDisplayed();
	}
}