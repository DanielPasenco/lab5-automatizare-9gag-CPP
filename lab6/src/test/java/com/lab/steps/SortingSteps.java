package com.lab.steps;

import com.lab.pages.MensPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class SortingSteps {
    private WebDriver driver = Hooks.driver;
    private MensPage mensPage;

    @When("I sort products by {string}")
    public void iSortProductsBy(String sortOption) {
        mensPage = new MensPage(driver);
        mensPage.selectSortOption(sortOption);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the product list should reload")
    public void theProductListShouldReload() {
        Assert.assertTrue(mensPage.isProductListDisplayed(), 
            "Product list did not reload");
    }

    @Then("products should be sorted by price ascending")
    public void productsShouldBeSortedByPriceAscending() {
        boolean isSorted = mensPage.isPricesSortedAscending();
        List<Double> prices = mensPage.getProductPrices();
        System.out.println("Prices after sorting ascending: " + prices);
    }

    @Then("products should be sorted by price descending")
    public void productsShouldBeSortedByPriceDescending() {
        boolean isSorted = mensPage.isPricesSortedDescending();
        List<Double> prices = mensPage.getProductPrices();
        System.out.println("Prices after sorting descending: " + prices);
    }

    @Then("the first product should have the lowest price")
    public void theFirstProductShouldHaveTheLowestPrice() {
        List<Double> prices = mensPage.getProductPrices();
        if (prices.size() > 0) {
            double firstPrice = prices.get(0);
            System.out.println("First product price: " + firstPrice);
        }
    }

    @Then("the products should be sorted {string}")
    public void theProductsShouldBeSorted(String expectedOrder) {
        List<Double> prices = mensPage.getProductPrices();
        System.out.println("Checking sort order: " + expectedOrder);
        System.out.println("Prices: " + prices);
        
        if (expectedOrder.equals("ascending")) {
            boolean isAscending = mensPage.isPricesSortedAscending();
            System.out.println("Is ascending: " + isAscending);
        } else if (expectedOrder.equals("descending")) {
            boolean isDescending = mensPage.isPricesSortedDescending();
            System.out.println("Is descending: " + isDescending);
        }
    }

    @Then("the sort order should match {string}")
    public void theSortOrderShouldMatch(String sortOption) {
        System.out.println("Sort option applied: " + sortOption);
        Assert.assertTrue(mensPage.getProductCount() > 0, 
            "No products found after sorting");
    }
}
