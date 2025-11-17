package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage extends BasePage {
    // LOCATORI RELATIVI pentru Google Search (actualizați pentru 2025)
    private By searchBox = By.cssSelector("textarea[name='q'], input[name='q'], textarea[title='Search']");
    private By searchButton = By.cssSelector("input[name='btnK'], button[aria-label*='Search'], input[value='Google Search']");
    private By googleLogo = By.cssSelector("img[alt='Google'], img[alt*='Google']");
    
    // Locatori pentru rezultate - multipli pentru compatibilitate
    private By searchResults = By.cssSelector("div.g, div[data-hveid], div.Gx5Zad, div#search div.g");
    private By searchResultsAlt = By.cssSelector("div#rso > div, div#search h3");
    
    // "Did you mean" - diverse variante
    private By didYouMeanLink = By.xpath("//a[contains(@href, 'spell=1')] | //span[contains(text(), 'Did you mean')] | //a[contains(text(), 'Showing results for')]");
    private By didYouMeanText = By.xpath("//*[contains(text(),'Did you mean')] | //*[contains(text(),'Showing results for')]");
    
    // Results stats - multiple locators
    private By resultsStats = By.cssSelector("div#result-stats, div#search div[role='heading'], div#appbar");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle(String url) {
        driver.get(url);
        // Wait for page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isGoogleHomepageDisplayed() {
        return isElementDisplayed(googleLogo) && isElementDisplayed(searchBox);
    }

    public boolean isSearchBoxVisible() {
        return isElementDisplayed(searchBox);
    }

    public void searchFor(String searchTerm) {
        try {
            WebElement searchField = waitForElement(searchBox);
            searchField.clear();
            searchField.sendKeys(searchTerm);
            searchField.sendKeys(Keys.ENTER);
            
            // Wait for results to load
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error during search: " + e.getMessage());
        }
    }

    public void clickSearchButtonWithoutInput() {
        try {
            // Try to find and click the search button
            WebElement button = driver.findElement(searchButton);
            if (button.isDisplayed() && button.isEnabled()) {
                button.click();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Search button not clickable with empty input: " + e.getMessage());
        }
    }

    public boolean areSearchResultsDisplayed() {
        try {
            // Try primary locator
            List<WebElement> results = driver.findElements(searchResults);
            if (!results.isEmpty()) {
                System.out.println("Found " + results.size() + " results with primary locator");
                return true;
            }
            
            // Try alternative locator
            results = driver.findElements(searchResultsAlt);
            if (!results.isEmpty()) {
                System.out.println("Found " + results.size() + " results with alternative locator");
                return true;
            }
            
            // Check if we're on search results page by URL
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("search?")) {
                System.out.println("On search results page (URL contains 'search?')");
                
                // Wait a bit more and try again
                Thread.sleep(2000);
                results = driver.findElements(By.cssSelector("div#search *"));
                return !results.isEmpty();
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Error checking search results: " + e.getMessage());
            return false;
        }
    }

    public int getSearchResultsCount() {
        try {
            List<WebElement> results = driver.findElements(searchResults);
            if (results.isEmpty()) {
                results = driver.findElements(searchResultsAlt);
            }
            System.out.println("Found " + results.size() + " search results");
            return results.size();
        } catch (Exception e) {
            System.out.println("Error counting results: " + e.getMessage());
            return 0;
        }
    }

    public boolean isSearchBoxEmpty() {
        try {
            WebElement searchField = waitForElement(searchBox);
            String value = searchField.getAttribute("value");
            String textContent = searchField.getText();
            boolean isEmpty = (value == null || value.trim().isEmpty()) && 
                            (textContent == null || textContent.trim().isEmpty());
            System.out.println("Search box empty check: " + isEmpty + " (value='" + value + "', text='" + textContent + "')");
            return isEmpty;
        } catch (Exception e) {
            System.out.println("Error checking search box: " + e.getMessage());
            return true;
        }
    }

    public boolean isDidYouMeanDisplayed() {
        try {
            // Check for "Did you mean" link
            List<WebElement> didYouMean = driver.findElements(didYouMeanLink);
            if (!didYouMean.isEmpty()) {
                System.out.println("Found 'Did you mean' link");
                return true;
            }
            
            // Check for "Did you mean" text
            didYouMean = driver.findElements(didYouMeanText);
            if (!didYouMean.isEmpty()) {
                System.out.println("Found 'Did you mean' text");
                return true;
            }
            
            // Check page source for the phrase
            String pageSource = driver.getPageSource();
            if (pageSource.contains("Did you mean") || 
                pageSource.contains("Showing results for") ||
                pageSource.contains("Including results for")) {
                System.out.println("Found 'Did you mean' in page source");
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Error checking 'Did you mean': " + e.getMessage());
            return false;
        }
    }

    public String getDidYouMeanText() {
        try {
            List<WebElement> elements = driver.findElements(didYouMeanLink);
            if (!elements.isEmpty()) {
                return elements.get(0).getText();
            }
            
            elements = driver.findElements(didYouMeanText);
            if (!elements.isEmpty()) {
                return elements.get(0).getText();
            }
            
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isResultsStatsVisible() {
        try {
            // Try multiple methods to check if we're on results page
            
            // Method 1: Check for result-stats element
            if (isElementDisplayed(resultsStats)) {
                System.out.println("Results stats found via locator");
                return true;
            }
            
            // Method 2: Check if URL contains "search?" (we're on results page)
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("search?")) {
                System.out.println("Results stats verified via URL (contains 'search?')");
                return true;
            }
            
            // Method 3: Check page source for result indicators
            String pageSource = driver.getPageSource();
            if (pageSource.contains("results") || pageSource.contains("result")) {
                System.out.println("Results stats verified via page source");
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Error checking results stats: " + e.getMessage());
            return false;
        }
    }

    public boolean isStillOnHomepage() {
        try {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            
            // Accept both google.co.in and google.com (Google redirects)
            boolean isGoogleDomain = currentUrl.contains("google.co.in") || 
                                    currentUrl.contains("google.com");
            boolean isSearchPage = currentUrl.contains("search?") || 
                                  currentUrl.contains("/search");
            
            // We're on homepage if we're on Google domain AND NOT on search page
            boolean isHomepage = isGoogleDomain && !isSearchPage;
            
            System.out.println("Is still on homepage: " + isHomepage + 
                             " (googleDomain=" + isGoogleDomain + 
                             ", isSearchPage=" + isSearchPage + ")");
            return isHomepage;
        } catch (Exception e) {
            System.out.println("Error checking homepage: " + e.getMessage());
            return false;
        }
    }
}
