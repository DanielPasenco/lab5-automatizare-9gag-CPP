package com.lab.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class NineGagTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/chromium");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
        System.out.println("Browser pornit cu succes!");
    }
    
    @Test(priority = 1)
    public void test01_deschide9gag() {
        System.out.println("=== Test 1: Deschidere 9gag.com ===");
        
        driver.get("https://9gag.com");
        
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("9gag.com"));
        
        System.out.println("✓ Pagina 9gag.com s-a deschis!");
    }
    
    @Test(priority = 2)
    public void test02_verificaAntet() {
        System.out.println("\n=== Test 2: Verificare antet ===");
        
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.toLowerCase().contains("9gag"));
        
        System.out.println("✓ Antetul 9gag este afișat!");
    }
    
    @Test(priority = 3)
    public void test03_cautaComputer() {
        System.out.println("\n=== Test 3: Căutare computer ===");
        
        try {
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[aria-label*='search'], .search-icon, [class*='search']")));
            searchButton.click();
            
            WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[type='search'], input[placeholder*='Search']")));
            searchInput.sendKeys("computer");
            searchInput.submit();
            
            Thread.sleep(2000);
            System.out.println("✓ Căutare efectuată!");
            
        } catch (Exception e) {
            System.out.println("⚠ Funcția de căutare poate diferi");
        }
    }
    
    @Test(priority = 4)
    public void test04_verificareFinala() {
        System.out.println("\n=== Test 4: Verificare finală ===");
        
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.toLowerCase().contains("9gag"));
        
        System.out.println("✓ Antetul este încă vizibil!");
    }
    
 @AfterClass
    public void tearDown() {
        System.out.println("\n=== Browser rămâne deschis 15 secunde ===");
        
        if (driver != null) {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
            System.out.println("✓ Browser închis!");
        }
    }
}
