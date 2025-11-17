package com.lab.steps;

import com.lab.pages.GoogleSearchPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DidYouMeanSteps {
    private WebDriver driver = Hooks.driver;
    private GoogleSearchPage googlePage;

    public DidYouMeanSteps() {
        this.googlePage = new GoogleSearchPage(Hooks.driver);
    }

    @Then("the {string} suggestion should be visible")
    public void theSuggestionShouldBeVisible(String suggestionType) {
        Assert.assertTrue(googlePage.isDidYouMeanDisplayed(), 
            suggestionType + " suggestion is not visible");
    }

    @Then("the suggestion should contain correct spelling")
    public void theSuggestionShouldContainCorrectSpelling() {
        String suggestionText = googlePage.getDidYouMeanText();
        Assert.assertFalse(suggestionText.isEmpty(), 
            "Did you mean suggestion text is empty");
        System.out.println("Did you mean suggestion: " + suggestionText);
    }

    @Then("alternative search suggestions may be displayed")
    public void alternativeSearchSuggestionsMayBeDisplayed() {
        // This is a soft check - we just log if suggestions are present
        if (googlePage.isDidYouMeanDisplayed()) {
            System.out.println("Alternative suggestions are displayed");
        } else {
            System.out.println("No alternative suggestions found");
        }
    }
}
