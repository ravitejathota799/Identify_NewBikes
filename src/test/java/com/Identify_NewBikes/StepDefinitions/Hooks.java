package com.Identify_NewBikes.StepDefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Identify_NewBikes.Utils.WebDriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	static WebDriver driver;
	static Properties p;

	// method for attaching screenshot
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// this is for cucumber junit report
		driver = WebDriverManager.getInstance().getDriver();
		if (!scenario.isFailed()) { // if scenario is passed
			TakesScreenshot ts = (TakesScreenshot) driver; // taking screenshot using takingScreenshot interfacess
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); // attaching the screen shot
		}
	}
}