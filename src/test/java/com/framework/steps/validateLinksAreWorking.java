package com.framework.steps;

import io.cucumber.java.en.Then;

public class validateLinksAreWorking {

	SharedContext context;

	public validateLinksAreWorking(SharedContext context) {
		this.context = context;
	}

	@Then("User will check if all the links are working fine on homepage")
	public void user_will_check_if_all_the_links_are_working_fine_on_homepage() {
		context.home.validateHomepageLinks();
	}
}