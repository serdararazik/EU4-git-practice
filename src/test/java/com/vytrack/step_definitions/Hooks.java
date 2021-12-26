package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp() {
        System.out.println("\tThis is coming from BEFORE");
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Thread.sleep(3000);
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpdb() {
        System.out.println("\tconnecting to database...");
    }

    @After("@db")
    public void closeddb() {
        System.out.println("\tdisconnecting to database...");
    }
}
