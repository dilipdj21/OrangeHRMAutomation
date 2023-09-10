package com.orangeHMR.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangeHRM.qa.utils.ExtentReporter;
import com.orangeHRM.qa.utils.Utilities;

public class MyListeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;

	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReport();

	}

	public void onTestStart(ITestResult result) {
		testName = result.getName(); // testName is enough in test start and can be used for other
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + "started successfully");
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, testName + "got successfully executed");

	}

	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {

			e.printStackTrace();

		}

		String destinationScreenshotPath = Utilities.captureScreenshot(driver, testName);

		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "got failed");

	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName + "got skipped ");

	}

	public void onFinish(ITestContext context) {
		extentReport.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "/test-output/ExtentReports/extentReport.html";

		File extentReport = new File(pathOfExtentReport);

		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
