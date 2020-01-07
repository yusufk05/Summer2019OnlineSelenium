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
}
