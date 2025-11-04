package com.lab.steps;

import com.lab.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        System.out.println("=== Test Started ===");
    }

    @After
    public void tearDown() {
        System.out.println("=== Test Finished ===");
        DriverManager.quitDriver();
    }
}
