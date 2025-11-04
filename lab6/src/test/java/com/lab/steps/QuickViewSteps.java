package com.lab.steps;

import com.lab.pages.MensPage;
import com.lab.pages.QuickViewModal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class QuickViewSteps {
    private WebDriver driver = Hooks.driver;
    private MensPage mensPage;
    private QuickViewModal quickViewModal;

    @When("I click on Quick View for first product")
    public void iClickOnQuickViewForFirstProduct() {
        mensPage = new MensPage(driver);
        try {
            mensPage.clickQuickView(0);
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Quick View button might not be available");
        }
    }

    @Given("Quick View modal is open")
    public void quickViewModalIsOpen() {
        mensPage = new MensPage(driver);
        try {
            mensPage.clickQuickView(0);
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Quick View modal might not open");
        }
        quickViewModal = new QuickViewModal(driver);
    }

    @Given("I am on a different page")
    public void iAmOnADifferentPage() {
        driver.get("https://adoring-pasteur-3ae17d.netlify.app/contact.html");
    }

    @Then("the Quick View modal should open")
    public void theQuickViewModalShouldOpen() {
        quickViewModal = new QuickViewModal(driver);
        Assert.assertTrue(quickViewModal.isModalDisplayed(), 
            "Quick View modal not displayed");
    }

    @Then("the modal content should load completely")
    public void theModalContentShouldLoadCompletely() {
        Assert.assertTrue(quickViewModal.isModalContentLoaded(), 
            "Modal content not loaded");
    }

    @Then("the product title should be displayed in modal")
    public void theProductTitleShouldBeDisplayedInModal() {
        Assert.assertTrue(quickViewModal.isModalTitleDisplayed(), 
            "Product title not displayed in modal");
    }

    @Then("the product price should be displayed in modal")
    public void theProductPriceShouldBeDisplayedInModal() {
        Assert.assertTrue(quickViewModal.isModalPriceDisplayed(), 
            "Product price not displayed in modal");
    }

    @Then("the product image should be displayed in modal")
    public void theProductImageShouldBeDisplayedInModal() {
        Assert.assertTrue(quickViewModal.isModalImageDisplayed(), 
            "Product image not displayed in modal");
    }

    @When("I click the close button")
    public void iClickTheCloseButton() {
        quickViewModal.clickCloseButton();
        quickViewModal.waitForModalToDisappear();
    }

    @Then("the modal should close")
    public void theModalShouldClose() {
        try {
            Thread.sleep(500);
            Assert.assertFalse(quickViewModal.isModalDisplayed(), 
                "Modal still displayed");
        } catch (Exception e) {
            // Modal closed successfully
        }
    }

    @Then("I should be back on mens page")
    public void iShouldBeBackOnMensPage() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("mens"));
    }

    @Then("Quick View modal should not open automatically")
    public void quickViewModalShouldNotOpenAutomatically() {
        quickViewModal = new QuickViewModal(driver);
        Assert.assertFalse(quickViewModal.isModalDisplayed(), 
            "Modal should not be displayed");
    }
}
