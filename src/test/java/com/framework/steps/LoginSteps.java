package com.framework.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	SharedContext context;

	public LoginSteps(SharedContext context) {
		this.context = context;
	}

	@Given("User launches the browser")
	public void user_launches_the_browser() {
		// Hooks handles this
	}

	@When("User navigates to Amazon")
	public void user_navigates_to_amazon() {
		System.out.println("Navigating to Amazon...");
	}

	@Then("User searches for {string}")
	public void user_searches_for(String product) {
		context.home.searchProduct(product);
	}

	@Then("User should see amazon logo")
	public void user_should_see_amazon_logo() {
		context.home.checkAmazonLogo();
	}
}