package com.libraryAutomation.stepDefinitions;


import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
