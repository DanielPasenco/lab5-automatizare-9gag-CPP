package com.lab.steps;

import com.lab.pages.GoogleSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonSteps {
    private WebDriver driver = Hooks.driver;
    private GoogleSearchPage googlePage;

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        googlePage = new GoogleSearchPage(driver);
        googlePage.navigateToGoogle(url);
    }

    @Then("the Google homepage should be displayed")
    public void theGoogleHomepageShouldBeDisplayed() {
        Assert.assertTrue(googlePage.isGoogleHomepageDisplayed(), 
            "Google homepage is not displayed");
    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        String actualTitle = googlePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), 
            "Page title does not contain: " + expectedTitle);
    }

    @Then("the search box should be visible")
    public void theSearchBoxShouldBeVisible() {
        Assert.assertTrue(googlePage.isSearchBoxVisible(), 
            "Search box is not visible");
    }
}
