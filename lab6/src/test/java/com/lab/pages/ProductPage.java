package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    
    // Locatori relativi
    private By productTitle = By.cssSelector("h1, .product-title, [class*='title']");
    private By productPrice = By.cssSelector(".product-price, .price, [class*='price']");
    private By productImage = By.cssSelector(".product-image img, .product img");
    private By productDescription = By.cssSelector(".product-description, .description, p");
    private By addToCartButton = By.cssSelector("button[class*='cart'], .add-to-cart, button:contains('Add')");
    private By backButton = By.cssSelector("a[href*='mens'], .back-btn, button:contains('Back')");
    private By notFoundMessage = By.cssSelector(".not-found, .error-404, h1:contains('404')");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void openProductPage(String productId) {
        navigateTo("/product.html?id=" + productId);
    }

    public boolean isProductTitleDisplayed() {
        return isDisplayed(productTitle);
    }

    public String getProductTitle() {
        return getText(productTitle);
    }

    public boolean isProductPriceDisplayed() {
        return isDisplayed(productPrice);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public boolean isProductImageDisplayed() {
        return isDisplayed(productImage);
    }

    public boolean isProductDescriptionDisplayed() {
        return isDisplayed(productDescription);
    }

    public boolean isAddToCartButtonDisplayed() {
        return isDisplayed(addToCartButton);
    }

    public void clickBackButton() {
        click(backButton);
    }

    public boolean isBackButtonDisplayed() {
        return isDisplayed(backButton);
    }

    public boolean is404PageDisplayed() {
        return isDisplayed(notFoundMessage) || getCurrentUrl().contains("404");
    }
}
