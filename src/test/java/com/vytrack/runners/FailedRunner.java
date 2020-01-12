package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",   // path to feature
        glue = "com/vytrack/step_definitions",       // path to definitions
        plugin = {  "html:target/default-cucumber-report"
        }

)

public class FailedRunner {
}
