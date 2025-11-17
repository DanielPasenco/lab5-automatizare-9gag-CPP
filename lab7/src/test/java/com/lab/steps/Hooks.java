package com.lab.steps;

import com.lab.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverManager.getDriver();
        System.out.println("=== Test Started: " + scenario.getName() + " ===");
    }

    @AfterStep
    public void captureScreenshotAfterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
            } catch (Exception e) {
                System.out.println("Could not take screenshot: " + e.getMessage());
            }
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Additional screenshot for failed scenarios
            takeScreenshot(scenario.getName());
        }
        System.out.println("=== Test Finished: " + scenario.getName() + " [" + scenario.getStatus() + "] ===");
        DriverManager.quitDriver();
    }

    private void takeScreenshot(String scenarioName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("target/screenshots/" + fileName);
            FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
