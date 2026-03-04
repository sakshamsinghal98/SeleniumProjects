package com.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/TestReport.html");
			spark.config().setReportName("Amazon Test Report");
			spark.config().setDocumentTitle("Test Results");
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}
}