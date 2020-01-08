Feature: Login
  As user, I want to be able to login into vytrack
  under different roles with username and password
  @store_manager
  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as store manager
    And user verifies that "Dashboard" subtitle is displayed

  @driver
  Scenario: Login as driver
    Given user is on the login page
    Then user logs in as a driver
    And user verifies that "Dashboard" subtitle is displayed

  @sales_manager
  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as sales manager
    And user verifies that "Dashboard" subtitle is displayed

  @negative_test
  Scenario: Verify that warning message is displayed when password is not correct
    Given user is on the login page
    Then user enters "storemanager85" username and "wrong" password
    And user verifies that "Invalid user name or password." massage is displayed

  @negative_test
  Scenario: Verify that warning message is displayed when username is not correct
    Given user is on the login page
    Then user enters "wrong username" username and "UserUser123" password
    And user verifies that "Invalid user name or password." massage is displayed



