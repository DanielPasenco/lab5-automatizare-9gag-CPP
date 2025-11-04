package com.lab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickViewModal extends BasePage {
    
    // Locatori relativi pentru modal
    private By modal = By.cssSelector(".modal, [role='dialog'], .quick-view-modal");
    private By modalTitle = By.cssSelector(".modal-title, .modal h2, .modal h3");
    private By modalPrice = By.cssSelector(".modal .price, .modal-price");
    private By modalImage = By.cssSelector(".modal img");
    private By closeButton = By.cssSelector(".modal .close, button[class*='close'], .modal-close");
    private By modalContent = By.cssSelector(".modal-content, .modal-body");

    public QuickViewModal(WebDriver driver) {
        super(driver);
    }

    public boolean isModalDisplayed() {
        return isDisplayed(modal);
    }

    public boolean isModalTitleDisplayed() {
        return isDisplayed(modalTitle);
    }

    public String getModalTitle() {
        return getText(modalTitle);
    }

    public boolean isModalPriceDisplayed() {
        return isDisplayed(modalPrice);
    }

    public String getModalPrice() {
        return getText(modalPrice);
    }

    public boolean isModalImageDisplayed() {
        return isDisplayed(modalImage);
    }

    public boolean isCloseButtonDisplayed() {
        return isDisplayed(closeButton);
    }

    public void clickCloseButton() {
        click(closeButton);
    }

    public boolean isModalContentLoaded() {
        return isDisplayed(modalContent);
    }

    public void waitForModalToDisappear() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
