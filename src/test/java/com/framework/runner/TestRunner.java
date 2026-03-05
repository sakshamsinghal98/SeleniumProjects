package com.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "com.framework.steps", plugin = {
		"pretty", "html:reports/TestReport.html" })

public class TestRunner extends AbstractTestNGCucumberTests {

}