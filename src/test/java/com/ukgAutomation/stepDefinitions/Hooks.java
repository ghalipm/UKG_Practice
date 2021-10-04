package com.ukgAutomation.stepDefinitions;


import com.ukgAutomation.utilities.BrowserUtils;
import com.ukgAutomation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Hooks {

    @After (order = 2)
    public void tearDownScenario(Scenario scenario) throws AWTException {
        //if my scenario failed
        // go and take screen shot

        if (!scenario.isFailed()) {

            System.out.println("About to zoom out");
            Robot robot = new Robot();
            // i=1 means zooming once.
            for (int i = 0; i < 1; i++) {
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }

            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }

        if (scenario.isFailed()) {

            Robot robot = new Robot();
            System.out.println("About to zoom in");
            for (int i = 0; i < 1; i++) {
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ADD);
                robot.keyRelease(KeyEvent.VK_ADD);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }

            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }

        BrowserUtils.sleep(1);
        Driver.closeDriver();

    }




}
