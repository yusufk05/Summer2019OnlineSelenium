package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDefinitions {
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("I am on the Login Page");
    }

    @Then("user logs in as store manager")
    public void user_logs_in_as_store_manager() {
        System.out.println("Login as store manager");
    }

    @Then("user verifies that {string} subtitle is displayed")
    public void user_verifies_that_subtitle_is_displayed(String string) {
        System.out.println("Verifing Page subtitle as " + string);
    }

    @Then("user logs in as a driver")
    public void user_logs_in_as_a_driver() {
        System.out.println("Logın as driver");
    }

    @Then("user logs in as sales manager")
    public void user_logs_in_as_sales_manager() {
        System.out.println("Login as sales manager");
    }

    @Then("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        System.out.println("Login with "+string+" username and "+string2+" password.");
    }

    @Then("user verifies that {string} massage is displayed")
    public void user_verifies_that_massage_is_displayed(String string) {
        System.out.println("Verifed that warning massage is displayed "+ string);
    }
}
