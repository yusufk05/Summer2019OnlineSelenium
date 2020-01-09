package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class TopMenuStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @When("user navigates to {string} then to {string}")
    public void user_navigates_to_then_to(String module, String submodule) {
        loginPage.navigateTo(module,submodule);
    }

}
