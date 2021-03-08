package com.libraryAutomation.stepDefinitions;


import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After (order = 2)
    public void tearDownScenario(Scenario scenario){
        //if my scenario failed
        // go and take screen shot
/*
        if (!scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
*/
        BrowserUtils.sleep(1);
        Driver.closeDriver();

    }



}
