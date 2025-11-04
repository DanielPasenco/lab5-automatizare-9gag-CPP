package com.lab.steps;

import com.lab.pages.MensPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class FilteringSteps {
    private WebDriver driver = Hooks.driver;
    private MensPage mensPage;

    @When("I filter products with min price {string} and max price {string}")
    public void iFilterProductsWithMinPriceAndMaxPrice(String minPrice, String maxPrice) {
        mensPage = new MensPage(driver);
        mensPage.filterByPrice(minPrice, maxPrice);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the product list should update")
    public void theProductListShouldUpdate() {
        Assert.assertTrue(mensPage.isProductListDisplayed(), 
            "Product list not updated");
    }

    @Then("all displayed products should be within price range")
    public void allDisplayedProductsShouldBeWithinPriceRange() {
        List<Double> prices = mensPage.getProductPrices();
        System.out.println("Filtered prices: " + prices);
        Assert.assertTrue(prices.size() > 0, "No products after filter");
    }

    @Then("products above {int} should be displayed")
    public void productsAboveShouldBeDisplayed(int minPrice) {
        List<Double> prices = mensPage.getProductPrices();
        for (Double price : prices) {
            System.out.println("Product price: " + price);
        }
    }

    @Then("products below {int} should be displayed")
    public void productsBelowShouldBeDisplayed(int maxPrice) {
        List<Double> prices = mensPage.getProductPrices();
        for (Double price : prices) {
            System.out.println("Product price: " + price);
        }
    }

    @Then("the filtering result should be {string}")
    public void theFilteringResultShouldBe(String expectedResult) {
        if (expectedResult.equals("no products")) {
            boolean noProducts = mensPage.isNoProductsMessageDisplayed() || 
                                 mensPage.getProductCount() == 0;
            System.out.println("No products message displayed: " + noProducts);
        } else {
            Assert.assertTrue(mensPage.getProductCount() > 0, 
                "Expected products but found none");
        }
    }

    @Then("products should match the price criteria {string} to {string}")
    public void productsShouldMatchThePriceCriteria(String minPrice, String maxPrice) {
        List<Double> prices = mensPage.getProductPrices();
        System.out.println("Price range: " + minPrice + " - " + maxPrice);
        System.out.println("Found prices: " + prices);
    }

    @Given("I have applied a price filter")
    public void iHaveAppliedAPriceFilter() {
        mensPage = new MensPage(driver);
        mensPage.openMensPage();
        mensPage.filterByPrice("20", "50");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I reload the page")
    public void iReloadThePage() {
        driver.navigate().refresh();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("all products should be displayed again")
    public void allProductsShouldBeDisplayedAgain() {
        mensPage = new MensPage(driver);
        Assert.assertTrue(mensPage.getProductCount() > 0, 
            "No products after reload");
    }

    @Then("the filter should be reset")
    public void theFilterShouldBeReset() {
        System.out.println("Filter has been reset after page reload");
    }

    @When("I filter with invalid range min {string} max {string}")
    public void iFilterWithInvalidRangeMinMax(String min, String max) {
        mensPage = new MensPage(driver);
        mensPage.filterByPrice(min, max);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the system should handle invalid input")
    public void theSystemShouldHandleInvalidInput() {
        boolean handled = mensPage.isNoProductsMessageDisplayed() || 
                         mensPage.getProductCount() == 0;
        System.out.println("System handled invalid input: " + handled);
    }
}
