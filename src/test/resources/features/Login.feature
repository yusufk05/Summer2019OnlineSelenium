Feature: Login
  As user, I want to be able to login into vytrack
  under different roles with username and password

  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as store manager
    And user verifies that "Dashboard" subtitle is displayed
# Any steps that was implemented before, can be reuse

  Scenario: Login as driver
    Given user is on the login page
    Then user logs in as a driver
    And user verifies that "Dashboard" subtitle is displayed

  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as sales manager
    And user verifies that "Dashboard" subtitle is displayed



