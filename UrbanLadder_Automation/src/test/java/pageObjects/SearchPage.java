package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By searchInput = By.id("search");
    By searchButton = By.xpath("//*[@id='search_button']");
    By filterNewArrivals = By.xpath("//label[contains(text(), 'New Arrivals')]");
    By filterPrice = By.xpath("//label[contains(text(), 'Price')]");
    By filterRatings = By.xpath("//label[contains(text(), 'Ratings')]");
    By searchBox = By.xpath("//*[@id='search']");
    By searchResultsHeader = By.xpath("//*[@id='search-results']/div[1]/h2/span");
    
    // Methods
    public void enterSearchTerm(String productName) {
        driver.findElement(searchInput).sendKeys(productName);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void filterByNewArrivals() {
        driver.findElement(filterNewArrivals).click();
    }

    public void filterByPrice() {
        driver.findElement(filterPrice).click();
    }

    public void filterByRatings() {
        driver.findElement(filterRatings).click();
    }
    public void searchProduct(String productName) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.clear();
        searchInput.sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public boolean isSearchResultsDisplayed() {
        try {
            WebElement resultsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsHeader));
            return resultsHeader.isDisplayed();
        } catch (Exception e) {
            System.out.println("Search results not displayed: " + e.getMessage());
            return false;
        }
    }

}