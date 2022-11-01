package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before
    public void setup(Scenario scenario) {
        System.out.println("----@Before each scenario----setting up browser------");
        System.out.println("----HOOK CLASS ------- SETUP SCENARIO------");
        System.out.println("Scenario name: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("---@After each scenario----closing browser------");
        System.out.println("---HOOK CLASS----TEARDOWN SCENARIO------");

        if(scenario.isFailed()){
            byte[]screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }
}
