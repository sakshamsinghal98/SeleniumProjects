package com.framework.steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.base.BaseClass;
import com.framework.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	ExtentReports extent = ExtentReportManager.getInstance();
	ExtentTest test;
	SharedContext context;

	public Hooks(SharedContext context) {
		this.context = context;
	}

	@Before
	public void setUp(Scenario scenario) {
		test = extent.createTest(scenario.getName());
		BaseClass.launchBrowser();
		context.initPages();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((org.openqa.selenium.TakesScreenshot) BaseClass.driver)
					.getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
			test.fail("Test Failed: " + scenario.getName())
					.addScreenCaptureFromBase64String(java.util.Base64.getEncoder().encodeToString(screenshot));
		} else {
			test.pass("Test Passed: " + scenario.getName());
		}
		extent.flush();
		BaseClass.closeBrowser();
	}
}