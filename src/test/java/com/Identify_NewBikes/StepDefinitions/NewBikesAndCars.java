package com.Identify_NewBikes.StepDefinitions;

import java.io.IOException;

import com.Identify_NewBikes.PageObjects.Locators;
import com.Identify_NewBikes.Utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewBikesAndCars extends WebDriverManager{

	Locators loc = new Locators(WebDriverManager.getInstance().getDriver());;

	@Given("user navigates to zig wheels website with url")
	public void user_navigates_to_zig_wheels_website_with_url() {
		loc = new Locators(WebDriverManager.getInstance().getDriver());
		WebDriverManager.getInstance().getLogger().info("User Navigate to zig wheels website successfully");
	}

	@When("Upon hovering their mouse over the new bikes, the user will be able to view more details regarding the products.")
	public void upon_hovering_their_mouse_over_the_new_bikes_the_user_will_be_able_to_view_more_details_regarding_the_products() {
		loc.hoverOnNewBikes();
		WebDriverManager.getInstance().getLogger().info("--Hover on new bikes option--");
	}

	@Then("From the new bikes area, the user selects the upcoming bikes option.")
	public void from_the_new_bikes_area_the_user_selects_the_upcoming_bikes_option() {
		loc.clickOnUpcomingBikes();
		WebDriverManager.getInstance().getLogger().info("--UpComing Bikes Option Selected--");
	}

	@Then("After receiving the result, the user selects Honda as the manufacturer name from the menu.")
	public void after_receiving_the_result_the_user_selects_honda_as_the_manufacturer_name_from_the_menu() {
		loc.selectManfacturerName();
		WebDriverManager.getInstance().getLogger().info("--Manfacturer Name Selected--");
	}

	@Then("record the name, cost, and anticipated release date of each bike for the Indian market for the manufacturer Honda & A bike should cost no more than four lakhs.")
	public void record_the_name_cost_and_anticipated_release_date_of_each_bike_for_the_indian_market_for_the_manufacturer_honda_a_bike_should_cost_no_more_than_four_lakhs()
			throws IOException {
		loc.captureBikesData();
		WebDriverManager.getInstance().getLogger().info("--Data inserted Successfully--");
	}

	@Given("user moves the mouse pointer over the Zig Wheels website new cars section.")
	public void user_moves_the_mouse_pointer_over_the_zig_wheels_website_new_cars_section() {
		loc.hoverOnUsedCars();
		WebDriverManager.getInstance().getLogger().info("--Hovered on Used Cars--");
	}

	@Then("From the website new cars area, the user selects the options for used cars in Chennai.")
	public void from_the_website_new_cars_area_the_user_selects_the_options_for_used_cars_in_chennai() {
		loc.clickonUsedCars();
		WebDriverManager.getInstance().getLogger().info("--Clicked on Used Cars--");
	}

	@Then("the user selects the options for used cars in {string}.")
	public void the_user_selects_the_options_for_used_cars_in(String cityName) {
		loc.clickonCity(cityName);
		WebDriverManager.getInstance().getLogger().info("--Clicked on Used Cars--");
	}

	@Then("On the Zig Wheels website, the user clicks on each and every modelName under the filters.")
	public void on_the_zig_wheels_website_the_user_clicks_on_each_and_every_model_name_under_the_filters()
			throws IOException, InterruptedException {
		loc.addFilters();
		WebDriverManager.getInstance().getLogger().info("--Filters Added--");
	}

	@Given("User clicks the Zig Wheels website login\\/signup button.")
	public void user_clicks_the_zig_wheels_website_s_login_signup_button() throws InterruptedException {
		loc.clickOnLoginorSignup();
		WebDriverManager.getInstance().getLogger().info("--Clicked On Login\\/Signup Button--");
	}

	@Given("The user choose a Google login option.")
	public void the_user_choose_a_google_login_option() {
		loc.clickOnGoogle();
		WebDriverManager.getInstance().getLogger().info("--Clicked On Google--");
	}

	@Then("User sends an incorrect email using their {string} address, then checks to see whether an error message appears.")
	public void user_sends_an_incorrect_email_using_their_address_then_checks_to_see_whether_an_error_message_appears(
			String emailId) {
		loc.enterEmailId(emailId);
		WebDriverManager.getInstance().getLogger().info("--Error Message validated--");
	}

	@Given("user navigate to forums tab in the zig wheels website")
	public void user_navigate_to_forums_tab_in_the_zig_wheels_website() {
		loc.clickOnForum();
		WebDriverManager.getInstance().getLogger().info("--Clicked On Forum--");
		
	}

	@When("On the zig wheels website, the user selects the type of vehicle")
	public void on_the_zig_wheels_website_the_user_selects_the_type_of_vehicle() {
		loc.selectVehicleType();
		WebDriverManager.getInstance().getLogger().info("--Selected Vehicle Type");
	}

	@When("The user selects a brand from the zig wheels web site")
	public void the_user_selects_a_brand_from_the_zig_wheels_web_site() {
		loc.selectBrand();
		WebDriverManager.getInstance().getLogger().info("--Selected Brand--");
	}

	@When("The user selects a model from the zig wheels web site based on the brand")
	public void the_user_selects_a_model_from_the_zig_wheels_web_site_based_on_the_brand() {
		loc.selectModel();
		WebDriverManager.getInstance().getLogger().info("--Selected Model--");
	}

	@Then("The user clicks on search button and validate the results")
	public void the_user_clicks_on_search_button_and_validate_the_results() {
		loc.clickOnSearch();
		WebDriverManager.getInstance().getLogger().info("User Clicked on Search Button");
	}

	@Given("user clicks on the search box and sends text as {string}")
	public void user_clicks_on_the_search_box_and_sends_text_as(String string) {
		loc.searchFunctionality(string);
		WebDriverManager.getInstance().getLogger().info("clicked on search box");
	}

	@Then("click on search and validate the error message diplayed")
	public void click_on_search_and_validate_the_error_message_diplayed() {
		loc.captureError();
		WebDriverManager.getInstance().getLogger().info("Error messafe validated");
	}
}
