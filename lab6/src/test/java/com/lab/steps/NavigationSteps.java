package com.lab.steps;

import com.lab.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavigationSteps {
    private WebDriver driver = Hooks.driver;
    private HomePage homePage;

    @When("I click on {string} link")
    public void iClickOnLink(String linkName) {
        homePage = new HomePage(driver);
        switch (linkName) {
            case "Home":
                homePage.clickHomeLink();
                break;
            case "Mens":
                homePage.clickMensLink();
                break;
            case "Womens":
                homePage.clickWomensLink();
                break;
            case "Contact":
                homePage.clickContactLink();
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I navigate to invalid page {string}")
    public void iNavigateToInvalidPage(String page) {
        homePage = new HomePage(driver);
        homePage.navigateToInvalidPage(page);
    }

    @Then("I should be on the home page")
    public void iShouldBeOnTheHomePage() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.endsWith("/") || url.contains("index.html"));
    }

    @Then("I should be on the mens page")
    public void iShouldBeOnTheMensPage() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("mens"));
    }

    @Then("I should be on the womens page")
    public void iShouldBeOnTheWomensPage() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("womens"));
    }

    @Then("I should be on the contact page")
    public void iShouldBeOnTheContactPage() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("contact"));
    }
}
