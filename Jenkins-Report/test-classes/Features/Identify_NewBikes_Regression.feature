@tag
Feature: Identify New Bikes and cars Regression TestSuite

  @Regression
  Scenario: Display "Upcoming" bikes details like bike name, price and expected launch date in India, for manufacturer 'Honda' & Bike price should be less than 4Lac.
    Given user navigates to zig wheels website with url
    When Upon hovering their mouse over the new bikes, the user will be able to view more details regarding the products.
    Then From the new bikes area, the user selects the upcoming bikes option.
    And After receiving the result, the user selects Honda as the manufacturer name from the menu.
    And record the name, cost, and anticipated release date of each bike for the Indian market for the manufacturer Honda & A bike should cost no more than four lakhs.

  
  @Regression
  Scenario: Verifying the forums in the zig wheels website
    Given user navigate to forums tab in the zig wheels website
    When On the zig wheels website, the user selects the type of vehicle
    And The user selects a brand from the zig wheels web site
    And The user selects a model from the zig wheels web site based on the brand
    Then The user clicks on search button and validate the results

  @Regression
  Scenario Outline: Hovering on used cars
    Given user moves the mouse pointer over the Zig Wheels website new cars section.
    Then the user selects the options for used cars in "<cityName>".

    Examples: 
      | cityName  |
      | Delhi     |
      | Mumbai    |
      | Banglore  |
      | Chennai   |
      | Hyderabad |
      | Kolkata   |
      | Ahmedabad |
      | Jaipur    |
      | Pune      |
