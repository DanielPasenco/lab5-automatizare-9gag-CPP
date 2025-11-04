package com.lab.steps;

import com.lab.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageSteps {
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage = new HomePage(driver);
        homePage.openHomePage();
    }

    @When("the page loads completely")
    public void thePageLoadsCompletely() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the header should be displayed")
    public void theHeaderShouldBeDisplayed() {
        Assert.assertTrue(homePage.isHeaderDisplayed(), "Header is not displayed");
    }

    @Then("the logo should be visible")
    public void theLogoShouldBeVisible() {
        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not visible");
    }

    @Then("the navigation menu should be displayed")
    public void theNavigationMenuShouldBeDisplayed() {
        Assert.assertTrue(homePage.isNavigationMenuDisplayed(), 
            "Navigation menu is not displayed");
    }

    @Then("product images should be displayed")
    public void productImagesShouldBeDisplayed() {
        boolean imagesDisplayed = homePage.areProductImagesDisplayed();
        System.out.println("Product images displayed: " + imagesDisplayed);
    }
}
