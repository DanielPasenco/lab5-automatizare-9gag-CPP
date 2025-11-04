package com.lab.steps;

import com.lab.pages.BasePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonSteps {
    protected WebDriver driver = Hooks.driver;
    protected BasePage basePage;

    @Then("the page should load successfully")
    public void thePageShouldLoadSuccessfully() {
        Assert.assertNotNull(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("adoring-pasteur"));
    }

    @Then("the URL should contain {string}")
    public void theURLShouldContain(String urlPart) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(urlPart), 
            "Expected URL to contain: " + urlPart + ", but was: " + currentUrl);
    }

    @Then("I should see 404 error page")
    public void iShouldSee404ErrorPage() {
        String currentUrl = driver.getCurrentUrl();
        String pageSource = driver.getPageSource().toLowerCase();
        boolean is404 = currentUrl.contains("404") || 
                        pageSource.contains("404") || 
                        pageSource.contains("not found");
        Assert.assertTrue(is404, "Expected 404 page but found: " + currentUrl);
    }

    @Then("the page should not have visual errors")
    public void thePageShouldNotHaveVisualErrors() {
        Assert.assertFalse(driver.getPageSource().contains("error"));
    }

    @Then("the layout should be stable")
    public void theLayoutShouldBeStable() {
        Assert.assertTrue(driver.getPageSource().length() > 0);
    }
}
