package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook {

    @Before
    public void setup(){
        System.out.println("############################");
        System.out.println("Test Setup");
    }

    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println("Test Failed");
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } else {
            System.out.println("Clean up!");
            System.out.println("Test Completed!");
        }
        System.out.println("############################");
        System.out.println();
        Driver.close();
    }
}
