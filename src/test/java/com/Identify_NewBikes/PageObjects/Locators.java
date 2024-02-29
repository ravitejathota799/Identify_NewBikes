package com.Identify_NewBikes.PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Identify_NewBikes.Utils.DataReader;

public class Locators extends BasePage {
	//constructor for web driver
	public Locators(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver; // Initializing JavascriptExecutor
	String file = System.getProperty("user.dir") + "/src/test/resources/Identify_NewBikes.xlsx"; 	//excel file path
	Actions a = new Actions(driver);		//creating an instance for actions 
	static By hoverEle = By.xpath("//a[normalize-space()='New Bikes']");	//xpath for hovering element
	static By upComingBikes = By.xpath("(//li)[90]");		//xpath for upcoming bikes option
	static By manfacturerName = By.xpath("//select[@id='makeId']");		//xpath for selecting manfacturer name
	static By viewMoreBikes = By.xpath("//span[@class='zw-cmn-loadMore']");		//xpath for view more bikes option
	static By bikes = By.xpath("//div[@class='p-15 pt-10 mke-ryt rel']");		//xpath for bikes
	static By usedCarsEle = By.xpath("(//a[normalize-space()='Used Cars'])[1]");	//xpath for usedCars dropdown
	static By usedCarsInChennai = By.xpath("(//li)[193]");			//xpath for used cars in chennai
	static By popularModel = By.xpath("//div[@class='gsc_thin_scroll']//ul//li");	//xpath for popular models in chennai
	static By usedCars = By.xpath("//div[@class=\"pt-10\"]/parent::div/a");			//xpath for used cars	
	static By footer = By.xpath("//footer[@id=\"Footer\"]");		//xapth for footer element
	static By homepage = By.xpath("//div[@class=\"col-lg-2\"]/a");	//xpath for homepage
	static By loginButton = By.xpath("//div[@id='forum_login_title_lg']");	//xpath for login button
	static By loginTab = By.xpath("//div[@class='modal fade in']");		//xpath for logintab
	static By emailTab = By.xpath("(//div[@class=\"newgf-login\"])[2]");	//xpath for emailTab
	static By emailId = By.xpath("//input[@id=\"identifierId\"]");		//xpath for emailId 
	static By nextButton = By.xpath("//div[@id=\"identifierNext\"]");	//xpath for next button
	static By error = By.xpath("//span[@class='jibhHc']");	//xpath for capturing the error
	static By forum = By.xpath("(//li)[200]");								//xpath for clicking the forum
	static By vehicleType = By.xpath("//select[@id='typeList']");			//xpath for selecting vehicle type
	static By brand = By.xpath("//select[@id='makeList']");					//xpath for selecting brand type
	static By model = By.xpath("//select[@id='modelList']");				//xpath for selecting model
	static By searchBox = By.xpath("(//input[@id='headerSearch'])[1]");
	static By searchResult = By.xpath("(//div[@class='alert alert-success text-center'])[1]");
	//method for hovering on new Bikes 
	public void hoverOnNewBikes() {
		try {
			a.moveToElement(driver.findElement(hoverEle)).build().perform();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	//method for clicking on upcoming bikes
	public void clickOnUpcomingBikes() {
		
		try {
			driver.findElement(upComingBikes).click();;
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	//method for seleting manfacuter
	public void selectManfacturerName() {
		try {
			Select s = new Select(driver.findElement(manfacturerName));
			s.selectByVisibleText("Honda");
		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	//method for capturing the data
	public void captureBikesData() throws IOException {
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(viewMoreBikes));
		js.executeScript("arguments[0].click();", driver.findElement(viewMoreBikes));
		List<WebElement> lst = driver.findElements(bikes);
		List<List<String>> values = new ArrayList<>();
		for (int i = 1; i < lst.size(); i++) {
			String bikeName = driver.findElement(By.xpath("(//div[@class=\"p-15 pt-10 mke-ryt rel\"])[" + i + "]/a"))
					.getText();
			String bikePrize = driver
					.findElement(By.xpath("((//div[@class=\"p-15 pt-10 mke-ryt rel\"])[" + i + "]/div)[1]")).getText();
			String launchDate = driver
					.findElement(By.xpath("((//div[@class=\"p-15 pt-10 mke-ryt rel\"])[" + i + "]/div)[2]")).getText();
			String prize = bikePrize.replace("Rs. ", "");
			Double prize2;
			if (prize.contains("Lakh")) {
				prize = prize.replace("Lakh", "");
				prize2 = Double.parseDouble(prize);
				prize2 = prize2 * 100000;
				if (prize2 < 400000) {
					values.add(List.of((bikeName), (bikePrize), (launchDate)));
				}
			} else if (!prize.contains("Crore")) {
				values.add(List.of((bikeName), (bikePrize), (launchDate)));
			}
		}
		for (int i = 1; i < values.size(); i++) {
			List<String> row = values.get(i);
			for (int j = 0; j < row.size(); j++) {
				DataReader.setCellData(file, "UpComingBikes", Integer.toString(i), j, row.get(j));
				System.out.print(row.get(j) + "\t");
			}
			System.out.println();
		}
		driver.navigate().to("https://www.zigwheels.com/");
	}

	//method for hovering on used cars 
	public void hoverOnUsedCars() {
		try {
			a.moveToElement(driver.findElement(usedCarsEle)).build().perform();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	//method for clicking on used cars in chennai
	public void clickonUsedCars() {
		try {
			driver.findElement(usedCarsInChennai).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	//method for adding filters
	public void addFilters() throws IOException, InterruptedException {
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='gsc_thin_scroll']//ul//li//label"));
		for (int i = 0; i < ele.size(); i++) {
			Thread.sleep(10000);
			js.executeScript("arguments[0].scrollIntoView(true)", ele.get(i));
			js.executeScript("arguments[0].click();", ele.get(i));
			Thread.sleep(10000);
			js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(footer));
			Thread.sleep(20000);
			
			// WebDriverWait(driver,Duration.ofSeconds(30)).ignoring(TimeoutException.class).until(ExpectedConditions.numberOfElementsToBe(usedCars,
			// Integer.parseInt(driver.findElement(By.xpath("//span[@class=\"ucCounth\"]")).getText())));
			List<WebElement> lst1 = driver.findElements(usedCars);
			List<List<String>> values = new ArrayList<>();
			for (int i1 = 1; i1 <= lst1.size(); i1++) {
				String carName = driver.findElement(By.xpath("(//div[@class=\"pt-10\"]/parent::div/a)[" + i1 + "]"))
						.getText();
				String carLocation = driver
						.findElement(By.xpath("((//div[@class=\"pt-10\"]/parent::div)[" + i1 + "]/span)[1]")).getText();
				String carPrize = driver.findElement(By.xpath("(//div[@class=\"pt-10\"]/span)[" + i1 + "]")).getText();
				values.add(List.of(carName, carLocation, carPrize));
			}
			for (int i1 = 1; i1 < values.size(); i1++) {
				List<String> row = values.get(i1);
				for (int j = 0; j < row.size(); j++) {
					DataReader.setCellData(file, ele.get(i).getText().toString(), Integer.toString(i1), j, row.get(j));
					System.out.print(row.get(j) + "\t");
				}
				System.out.println();
			}
			js.executeScript("arguments[0].scrollIntoView(true)", ele.get(i));
			js.executeScript("arguments[0].click();", ele.get(i));
		}

	}
	
	//method for clicking on login or signup
	public void clickOnLoginorSignup() throws InterruptedException {
		driver.navigate().to("https://www.zigwheels.com/");
		Thread.sleep(5000);
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	//method for clicking on google
	public void clickOnGoogle() {
		driver.findElement(emailTab).click();
		List<String> windowId = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowId.get(1));
	}

	//method for entering email id
	public void enterEmailId(String email) {
		driver.findElement(emailId).sendKeys(email);
		driver.findElement(nextButton).click();
		System.out.println(driver.findElement(error).getText().toString());
		String s = driver.findElement(error).getText().toString();
		Assert.assertEquals(s, driver.findElement(error).getText().toString());
	}
	
	//method for clicking on forum
	public void clickOnForum() {
		try {
			driver.findElement(forum).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	//method for selecting vehicel type
	public void selectVehicleType() {
		driver.findElement(By.xpath("//div[@class='col-lg-3 col-xs-6 col-sm-3 pr-0'][1]")).click();
		String[] vType = { "Car", "Bike" };
		Random random = new Random();
		int index = random.nextInt(vType.length);
		Select s = new Select(driver.findElement(vehicleType));
		s.selectByVisibleText(vType[index]);
	}

	//method for selecting brand
	public void selectBrand() {
		driver.findElement(By.xpath("//div[@class='col-lg-3 col-xs-6 col-sm-3 pr-0 mpr-15'][1]")).click();
		Select s = new Select(driver.findElement(brand));
		List<WebElement> ele = s.getOptions();
		int n = ele.size();
		Random r = new Random();
		int rIdx = r.nextInt(n);
		s.selectByIndex(rIdx);
		ele.get(rIdx).click();
	}

	//method for selecting for model
	public void selectModel() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.findElement(By.xpath("(//div[@class='col-lg-3 col-xs-6 col-sm-3 pr-0'])[2]")).click();
		Select s = new Select(driver.findElement(model));
		List<WebElement> ele = s.getOptions();
		int n = ele.size();
		Random r = new Random();
		int rIdx = r.nextInt(n);
		s.selectByIndex(rIdx);
		ele.get(rIdx).click();
	}

	//method for clicking on search
	public void clickOnSearch() {
		driver.findElement(By.xpath("//div[@class='gallery-but']")).click();
		String forumName = driver.findElement(By.xpath("//div[@class='brand-comity-head']")).getText().toString();
		System.out.println(forumName);
	}

	//method for clicking on city
	public void clickonCity(String cityName) {
		try {
			driver.findElement(By.xpath("//div[@class='h-dd-r']//ul//li//span[contains(text(),'"+cityName+"')]")).click();
			String result = driver.findElement(By.xpath("//h1[@id='usedcarttlID']")).getText().toString();
			Assert.assertEquals(driver.findElement(By.xpath("//h1[@id='usedcarttlID']")).getText().toString(), result);
			System.out.println(result);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void searchFunctionality(String search) {
		driver.findElement(searchBox).sendKeys(search);
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}
	
	public void captureError() {
		System.out.println(driver.findElement(searchResult).getText().toString());
	}
}
