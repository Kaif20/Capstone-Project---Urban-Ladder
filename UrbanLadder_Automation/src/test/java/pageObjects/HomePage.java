package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage {
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
   // By topOffersSection = By.id("top-recently-viewed");
    By recommendedForYouSection = By.id("homepage_slider");
   // By searchBar = By.id("search");
    By searchBar = By.xpath("//*[@id='search']");
    By searchButton = By.xpath("//*[@id='search_button']");
    By topOffersSection = By.xpath("//*[@id='head-alert']/div/div/a/strong");

    // Methods
    public boolean isTopOffersDisplayed() {
        return driver.findElement(topOffersSection).isDisplayed();
    }

    public boolean isRecommendedForYouDisplayed() {
        return driver.findElement(recommendedForYouSection).isDisplayed();
    }

    public void searchForProduct(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(By.id("search-button")).click();
    }
    public boolean isSearchBarVisible() {
        WebElement element = driver.findElement(searchBar);
        return element.isDisplayed();
    }

    public boolean isSearchButtonVisible() {
        WebElement element = driver.findElement(searchButton);
        return element.isDisplayed();
    }

    public boolean isTopOffersVisible() {
        WebElement element = driver.findElement(topOffersSection);
        return element.isDisplayed();
    }

    public void enterSearch(String productName) {
        driver.findElement(searchBar).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

}