package com.framework.steps;

import org.openqa.selenium.WebDriver;

import com.framework.base.BaseClass;
import com.framework.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;

	HomePage home = new HomePage(driver);

	@Given("User launches the browser")
	public void user_launches_the_browser() {
		driver = BaseClass.driver;
		home = new HomePage(driver);
	}

	@When("User navigates to Amazon")
	public void user_navigates_to_amazon() {
		System.out.println("Navigating to Amazon...");
	}

	@Then("User searches for {string}")
	public void user_searches_for(String product) {
		home.searchProduct(product);
	}

	@Then("User should see amazon logo")
	public void user_should_see_amazon_logo() {
		home.checkAmazonLogo();
	}

}
