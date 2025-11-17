package com.lab.steps;

import com.lab.pages.GoogleSearchPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchSteps {
    private WebDriver driver = Hooks.driver;
    private GoogleSearchPage googlePage;

    public SearchSteps() {
        this.googlePage = new GoogleSearchPage(Hooks.driver);
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        googlePage.searchFor(searchTerm);
    }

    @When("I click search button without entering any text")
    public void iClickSearchButtonWithoutEnteringAnyText() {
        googlePage.clickSearchButtonWithoutInput();
    }

    @Then("search results should be displayed")
    public void searchResultsShouldBeDisplayed() {
        Assert.assertTrue(googlePage.areSearchResultsDisplayed(), 
            "Search results are not displayed");
    }

    @Then("I should see at least {int} results on the page")
    public void iShouldSeeAtLeastResultsOnThePage(int expectedCount) {
        int actualCount = googlePage.getSearchResultsCount();
        Assert.assertTrue(actualCount >= expectedCount, 
            "Expected at least " + expectedCount + " results, but found: " + actualCount);
    }

    @Then("the results count should be visible")
    public void theResultsCountShouldBeVisible() {
        Assert.assertTrue(googlePage.isResultsStatsVisible(), 
            "Results count is not visible");
    }

    @Then("I should remain on the Google homepage")
    public void iShouldRemainOnTheGoogleHomepage() {
        Assert.assertTrue(googlePage.isStillOnHomepage(), 
            "User navigated away from homepage");
    }

    @Then("the search box should still be empty")
    public void theSearchBoxShouldStillBeEmpty() {
        Assert.assertTrue(googlePage.isSearchBoxEmpty(), 
            "Search box is not empty");
    }

    @Then("no search results should be displayed")
    public void noSearchResultsShouldBeDisplayed() {
        Assert.assertFalse(googlePage.areSearchResultsDisplayed(), 
            "Search results are displayed when they shouldn't be");
    }

    @Then("search results should be displayed or suggestion shown")
    public void searchResultsShouldBeDisplayedOrSuggestionShown() {
        boolean hasResults = googlePage.areSearchResultsDisplayed();
        boolean hasSuggestion = googlePage.isDidYouMeanDisplayed();
        Assert.assertTrue(hasResults || hasSuggestion, 
            "Neither search results nor suggestions are displayed");
    }
}
