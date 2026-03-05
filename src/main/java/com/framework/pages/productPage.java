package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.BaseClass;

public class productPage {

	WebDriver driver;

	@FindBy(xpath = "(//div[@data-cy=\"title-recipe\"])[1]")
	WebElement product;

	@FindBy(id = "productTitle")
	WebElement producttitle;

	@FindBy(xpath = "//div[@id=\"desktop_qualifiedBuyBox\"]//span[text()=\"Add to cart\"]")
	WebElement addToCartButton;

	public productPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnProduct() {
		BaseClass.waitForElement(product);
		product.click();
	}

	public void switchToProductTab() {
		BaseClass.waitForElement(product);
		BaseClass.switchToNewTab(driver);
	}

	public void validateProductTitle() {
		BaseClass.waitForElement(producttitle);
		producttitle.isDisplayed();
		System.out.println(producttitle.getText());
	}

	public void validateAddToCartButton() {
		BaseClass.waitForElement(addToCartButton);
		addToCartButton.isEnabled();
	}

}
