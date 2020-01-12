Feature: Login
  As user, I want to be able to login into vytrack
  under different roles with username and password
  @store_manager
  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as store manager
    And user verifies that "Dashboard" page subtitle is displayed

  @driver
  Scenario: Login as driver
    Given user is on the login page
    Then user logs in as driver
    And user verifies that "Dashboard" page subtitle is displayed

  @sales_manager
  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as sales manager
    And user verifies that "Dashboard" page subtitle is displayed

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

  @driver_with_datatable
  Scenario: Login as driver (data table example)
    Given user is on the login page
    Then user logs in as driver with following credentials
      | username  | user160     |
      | password  | UserUser123 |
    And user verifies that "Quick Launchpad" page subtitle is displayed

  @Login_with_role
  Scenario: Login as driver
    Given user is on the login page
    Then user logs in as "driver"

  @Login_with_role
  Scenario: Login as sales manager
    Given user is on the login page
    Then user logs in as "sales manager"

  @Login_with_role
  Scenario: Login as store manager
    Given user is on the login page
    Then user logs in as "store manager"

  @Login_with_role_ddt
    Scenario Outline: DDT example, Login as <role>
      Given user is on the login page
      Then user logs in as "<role>"
    Examples:
      | role          |
      | driver        |
      | sales manager |
      | store manager |

  @login_with_credentials_ddt
  Scenario Outline: DDT example with credentials, Login as <username>
    Given user is on the login page
    Then user enters "<username>" username and "<password>" password
    Examples:
    | username        | password    |
    | storemanager85  | UserUser123 |
    | user160         | UserUser123 |
    | salesmanager110 | UserUser123 |

    @login_with_roles_ddt_2
  Scenario Outline: login as <role> and verify <title> page title is correct
    Given user is on the login page
    And user logs in as "<role>"
    When user navigates to "<module>" then to "<sub module>"
    Then the page title should be "<title>"
      Examples: drivers
    | role    | module     | sub module      | title                                                        |
    | driver  | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System            |
    | driver  | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
    | driver  | Customers  | Accounts        | Accounts - Customers                                         |
    | driver  | Customers  | Contacts        | Contacts - Customers                                         |
    | driver  | Activities | Calendar Events | Calendar Events - Activities                                 |
    | driver  | System     | Jobs            | Jobs - System                                                |

    Examples: drivers
    | role    | module     | sub module      | title                                                        |
    | sales manager  | Fleet      | Vehicles        | Car - Entities - System - Car - Entities - System            |
    | sales manager  | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System |
    | sales manager  | Customers  | Accounts        | Accounts - Customers                                         |
    | sales manager  | Customers  | Contacts        | Contacts - Customers                                         |
    | sales manager  | Activities | Calendar Events | Calendar Events - Activities                                 |
    | sales manager  | System     | Jobs            | Jobs - System                                                |

