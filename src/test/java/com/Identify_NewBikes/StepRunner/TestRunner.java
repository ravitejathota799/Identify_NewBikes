package com.Identify_NewBikes.StepRunner;

import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features = {
				"src/test/resources/Features/Identify_NewBikes_Smoke.feature", }, glue = "com.Identify_NewBikes.StepDefinitions", plugin = {
						"pretty", "rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" ,
						"html:Cucumber-reports/report.html", }, dryRun = false, monochrome = true,publish = true)

@Test
public class TestRunner extends AbstractTestNGCucumberTests{

}
