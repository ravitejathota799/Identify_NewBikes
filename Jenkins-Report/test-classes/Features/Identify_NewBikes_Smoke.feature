Feature: Identify New Bikes Smoke TestSuite

  @smoke
  Scenario: Hovering mouse on the new Bikes dropdown
    Given user navigates to zig wheels website with url
    When Upon hovering their mouse over the new bikes, the user will be able to view more details regarding the products.

  @smoke
  Scenario: Selecting the "upcoming" options from new bikes drop down
    Given user navigates to zig wheels website with url
    When Upon hovering their mouse over the new bikes, the user will be able to view more details regarding the products.
    Then From the new bikes area, the user selects the upcoming bikes option.
    And After receiving the result, the user selects Honda as the manufacturer name from the menu.

  @smoke
  Scenario: Hovering on used cars
    Given user moves the mouse pointer over the Zig Wheels website new cars section.
    Then From the website new cars area, the user selects the options for used cars in Chennai.

  @smoke
  Scenario: Try to 'Login' with google, give invalid account details & capture the error message
    Given User clicks the Zig Wheels website login/signup button.
    And The user choose a Google login option.
    Then User sends an incorrect email using their "<emailId>" address, then checks to see whether an error message appears.

    Examples: 
      | emailId          |
      | vggdxcggmail.com |

  #Negative Scenario
  @Smoke
  Scenario: Try to give invalid details in the search bar and capture the error
    Given user clicks on the search box and sends text as "<search>"
    Then click on search and capture the error message diplayed

    Examples: 
      | search           |
      | Slkgjsijg;osejdg |
