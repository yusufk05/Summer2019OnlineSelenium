package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("I am on the Login Page");
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user logs in as store manager")
    public void user_logs_in_as_store_manager() {
        System.out.println("Login as store manager");
        String userName = ConfigurationReader.getProperty("user_name");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(userName, password);
    }

    @Then("user verifies that {string} subtitle is displayed")
    public void user_verifies_that_subtitle_is_displayed(String string) {
        loginPage.waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(2);
        Assert.assertEquals(string, loginPage.getPageSubTitle());
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
