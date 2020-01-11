Feature: Create new car

  Scenario: Create a car
    Given user is on the login page
    And user logs in as store manager
    Then user navigates to "Fleet" then to "Vehicles"
    And user click on "Create"
    Then user adds new car information:
      |License Plate  | Driver      | Location  | Model Year  | Color |
      |TestPlates     | TestDriver  | Florida   | 2020        | Blue  |