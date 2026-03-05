package com.framework.steps;

import org.openqa.selenium.WebDriver;

import com.framework.base.BaseClass;
import com.framework.pages.HomePage;

import io.cucumber.java.en.Then;

public class validateLinksAreWorking {
	WebDriver driver;

	HomePage home = new HomePage(driver);

	@Then("User will check if all the links are working fine on homepage")
	public void user_will_check_if_all_the_links_are_working_fine_on_homepage() {
	    driver = BaseClass.driver;
	    home = new HomePage(driver);
		home.validateHomepageLinks();
	}

}
