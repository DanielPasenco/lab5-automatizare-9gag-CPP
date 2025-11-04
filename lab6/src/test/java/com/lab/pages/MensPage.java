package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MensPage extends BasePage {
    
    // Locatori relativi
    private By productList = By.cssSelector(".product-list, .products, [class*='product']");
    private By productItems = By.cssSelector(".product-item, .product, [class*='product-card']");
    private By productNames = By.cssSelector(".product-name, .product-title, h3, h4");
    private By productPrices = By.cssSelector(".product-price, .price, [class*='price']");
    private By productImages = By.cssSelector(".product img");
    private By quickViewButtons = By.cssSelector(".quick-view, [class*='quick'], button[data-product]");
    private By sortDropdown = By.cssSelector("select[name='sort'], #sort, .sort-select");
    private By filterPriceMin = By.cssSelector("input[name='min'], #min-price, [placeholder*='Min']");
    private By filterPriceMax = By.cssSelector("input[name='max'], #max-price, [placeholder*='Max']");
    private By filterButton = By.cssSelector("button[type='submit'], .filter-btn, .apply-filter");
    private By noProductsMessage = By.cssSelector(".no-products, .empty-state, [class*='no-result']");

    public MensPage(WebDriver driver) {
        super(driver);
    }

    public void openMensPage() {
        navigateTo("/mens.html");
    }

    public boolean isProductListDisplayed() {
        return isDisplayed(productList);
    }

    public int getProductCount() {
        return findElements(productItems).size();
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement element : findElements(productNames)) {
            names.add(element.getText());
        }
        return names;
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement element : findElements(productPrices)) {
            String priceText = element.getText().replaceAll("[^0-9.]", "");
            if (!priceText.isEmpty()) {
                prices.add(Double.parseDouble(priceText));
            }
        }
        return prices;
    }

    public boolean areProductImagesDisplayed() {
        return findElements(productImages).size() > 0;
    }

    public void clickFirstProduct() {
        click(productItems);
    }

    public void clickQuickView(int index) {
        findElements(quickViewButtons).get(index).click();
    }

    public void selectSortOption(String option) {
        WebElement dropdown = findElement(sortDropdown);
        dropdown.click();
        dropdown.sendKeys(option);
    }

    public void filterByPrice(String min, String max) {
        type(filterPriceMin, min);
        type(filterPriceMax, max);
        click(filterButton);
    }

    public boolean isNoProductsMessageDisplayed() {
        return isDisplayed(noProductsMessage);
    }

    public boolean isPricesSortedAscending() {
        List<Double> prices = getProductPrices();
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPricesSortedDescending() {
        List<Double> prices = getProductPrices();
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
