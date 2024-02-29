package com.Identify_NewBikes.StepRunner;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Identify_NewBikes.Utils.ExtentReportManager;
import com.Identify_NewBikes.Utils.WebDriverManager;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

		features = { "src/test/resources/Features", }, glue = "com.Identify_NewBikes.StepDefinitions", plugin = {
				"pretty", "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:Cucumber-reports/report.html", }, dryRun = false, monochrome = true, publish = true)

@Test
@Listeners(ExtentReportManager.class)
public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(String browser) throws IOException {
		WebDriverManager.getInstance().createDriver(browser);
	}

	@AfterMethod
	public void tearDown() {
		WebDriverManager.getInstance().quitDriver();
	}
}
