package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
    // Locatori relativi - nu folosim căi absolute
    private By header = By.cssSelector("header");
    private By logo = By.cssSelector("header img, header .logo");
    private By navigationMenu = By.cssSelector("nav, .navigation");
    private By homeLink = By.linkText("Home");
    private By mensLink = By.linkText("Mens");
    private By womensLink = By.linkText("Womens");
    private By contactLink = By.linkText("Contact");
    private By productList = By.cssSelector(".product-list, .products");
    private By productItems = By.cssSelector(".product-item, .product");
    private By productImages = By.cssSelector(".product img");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        navigateTo("/");
    }

    public boolean isHeaderDisplayed() {
        return isDisplayed(header);
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(logo);
    }

    public boolean isNavigationMenuDisplayed() {
        return isDisplayed(navigationMenu);
    }

    public void clickHomeLink() {
        click(homeLink);
    }

    public void clickMensLink() {
        click(mensLink);
    }

    public void clickWomensLink() {
        click(womensLink);
    }

    public void clickContactLink() {
        click(contactLink);
    }

    public boolean isProductListDisplayed() {
        return isDisplayed(productList);
    }

    public int getProductCount() {
        return findElements(productItems).size();
    }

    public boolean areProductImagesDisplayed() {
        return findElements(productImages).size() > 0;
    }

    public void navigateToInvalidPage(String page) {
        navigateTo("/" + page);
    }
}
