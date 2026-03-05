package com.framework.steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.framework.base.BaseClass;
import com.framework.utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

	ExtentReports extent = ExtentReportManager.getInstance();
	ExtentTest test;

	@Before
	public void setUp(Scenario scenario) {
		test = extent.createTest(scenario.getName());
		BaseClass.launchBrowser();
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
			test.fail("Test Failed: " + scenario.getName())
					.addScreenCaptureFromBase64String(java.util.Base64.getEncoder().encodeToString(screenshot));
			test.fail(scenario.getName());
		} else {
			test.pass("Test Passed: " + scenario.getName());
		}
		extent.flush();
		BaseClass.closeBrowser();
	}
	

}