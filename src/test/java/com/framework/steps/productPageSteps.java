package com.framework.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class productPageSteps {
	SharedContext context;

	public productPageSteps(SharedContext context) {
		this.context = context;
	}

	@When("User clicks on any product from the list of products")
	public void user_clicks_on_any_product_from_the_list_of_products() {
		context.productpage.clickOnProduct();
	}

	@Then("User will land on that specific product page")
	public void user_will_land_on_that_specific_product_page() {
		context.productpage.switchToProductTab();
	}

	@Then("User will be able to validate the {string} of the product")
	public void user_will_be_able_to_validate_the_of_the_product(String fieldName) {
		context.productpage.validateProductTitle();
	}

	@Then("User will be able to validate the {string} button for that product")
	public void user_will_be_able_to_validate_the_button_for_that_product(String buttonName) {
		context.productpage.validateAddToCartButton();
	}

}
