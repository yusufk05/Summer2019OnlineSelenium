package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/activities",
                    "src/test/resources/features/fleet"},   // path to feature
        glue = "com/vytrack/step_definitions",       // path to definitions
        dryRun = false,  // by default
        plugin = {  "html:target/default-cucumber-report",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }

)
public class RegressionRunner {
}
