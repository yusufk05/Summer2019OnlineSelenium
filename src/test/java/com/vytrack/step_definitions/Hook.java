package com.vytrack.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public void setup(){
        System.out.println("Test Setup");
    }

    @After
    public void teardown(){
        System.out.println("Clean up!");
        System.out.println("Test Completed!");
    }
}
