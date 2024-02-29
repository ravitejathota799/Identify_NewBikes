@tag
Feature: Identify New Bike E2E testing suite in the zig wheels website

  Scenario: Display "Upcoming" bikes details like bike name, price and expected launch date in India, for manufacturer 'Honda' & Bike price should be less than 4Lac.
    Given user navigates to zig wheels website with url
    When Upon hovering their mouse over the new bikes, the user will be able to view more details regarding the products.
    Then From the new bikes area, the user selects the upcoming bikes option.
    And After receiving the result, the user selects Honda as the manufacturer name from the menu.
    And record the name, cost, and anticipated release date of each bike for the Indian market for the manufacturer Honda & A bike should cost no more than four lakhs.
    

  Scenario: For Used cars in Chennai, extract all the popular models in a List; Display the same
    Given user moves the mouse pointer over the Zig Wheels website new cars section.
    Then From the website new cars area, the user selects the options for used cars in Chennai.
    And On the Zig Wheels website, the user clicks on each and every modelName under the filters.


  Scenario: Try to 'Login' with google, give invalid account details & capture the error message
    Given User clicks the Zig Wheels website login/signup button.
    And The user choose a Google login option.
    Then User sends an incorrect email using their "<emailId>" address, then checks to see whether an error message appears.

    Examples: 
      | emailId          |
      | vggdxcggmail.com |
