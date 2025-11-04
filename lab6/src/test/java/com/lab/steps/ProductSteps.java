package com.lab.steps;

import com.lab.pages.MensPage;
import com.lab.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductSteps {
    private WebDriver driver = Hooks.driver;
    private MensPage mensPage;
    private ProductPage productPage;

    @Given("I am on the mens page")
    public void iAmOnTheMensPage() {
        mensPage = new MensPage(driver);
        mensPage.openMensPage();
    }

    @Given("I am on a product page")
    public void iAmOnAProductPage() {
        productPage = new ProductPage(driver);
        productPage.openProductPage("1");
    }

    @Given("I navigate to invalid product page")
    public void iNavigateToInvalidProductPage() {
        productPage = new ProductPage(driver);
        productPage.openProductPage("99999");
    }

    @Then("the product list should be visible")
    public void theProductListShouldBeVisible() {
        Assert.assertTrue(mensPage.isProductListDisplayed(), 
            "Product list is not visible");
    }

    @Then("products should have names displayed")
    public void productsShouldHaveNamesDisplayed() {
        Assert.assertTrue(mensPage.getProductNames().size() > 0, 
            "No product names found");
    }

    @Then("products should have prices displayed")
    public void productsShouldHavePricesDisplayed() {
        Assert.assertTrue(mensPage.getProductPrices().size() > 0, 
            "No product prices found");
    }

    @Then("products should have images displayed")
    public void productsShouldHaveImagesDisplayed() {
        Assert.assertTrue(mensPage.areProductImagesDisplayed(), 
            "Product images not displayed");
    }

    @When("I click on the first product")
    public void iClickOnTheFirstProduct() {
        mensPage.clickFirstProduct();
    }

    @Then("I should be redirected to product page")
    public void iShouldBeRedirectedToProductPage() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("product") || url.contains("id="));
    }

    @Then("the product title should be displayed")
    public void theProductTitleShouldBeDisplayed() {
        productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isProductTitleDisplayed(), 
            "Product title not displayed");
    }

    @Then("the product price should be displayed")
    public void theProductPriceShouldBeDisplayed() {
        Assert.assertTrue(productPage.isProductPriceDisplayed(), 
            "Product price not displayed");
    }

    @Then("the product image should be displayed")
    public void theProductImageShouldBeDisplayed() {
        Assert.assertTrue(productPage.isProductImageDisplayed(), 
            "Product image not displayed");
    }

    @Then("the product description should be displayed")
    public void theProductDescriptionShouldBeDisplayed() {
        Assert.assertTrue(productPage.isProductDescriptionDisplayed(), 
            "Product description not displayed");
    }

    @Then("the {string} button should be displayed")
    public void theButtonShouldBeDisplayed(String buttonName) {
        if (buttonName.equals("Add to cart")) {
            Assert.assertTrue(productPage.isAddToCartButtonDisplayed(), 
                "Add to cart button not displayed");
        } else if (buttonName.equals("Back")) {
            Assert.assertTrue(productPage.isBackButtonDisplayed(), 
                "Back button not displayed");
        }
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        if (buttonName.equals("Back")) {
            productPage.clickBackButton();
        }
    }

    @Then("I should return to mens page")
    public void iShouldReturnToMensPage() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("mens"), "Not on mens page");
    }
}
