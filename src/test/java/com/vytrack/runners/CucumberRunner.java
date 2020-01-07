package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // path to feature
        glue = "com/vytrack/step_definitions",       // path to definitions
        dryRun = false  // by default
)
public class CucumberRunner {

}
