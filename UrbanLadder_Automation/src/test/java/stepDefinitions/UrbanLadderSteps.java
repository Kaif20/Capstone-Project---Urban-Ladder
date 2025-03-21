package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchPage;
import pageObjects.ProductPage;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class UrbanLadderSteps {
    WebDriver driver;
    WebDriverWait wait;
    HomePage searchPage;
    ProductPage productPage;
    AccountPage accountPage;
    SearchPage New1;

    @Before
    public void setUp() {
        // Set up WebDriver for Chrome, Firefox, or Edge
        String browser = "chrome"; // Change this to "firefox" or "edge" for cross-browser testing
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        searchPage = new HomePage(driver);
        productPage = new ProductPage(driver);
        accountPage = new AccountPage(driver);
        New1 = new SearchPage(driver);
    }

    @Given("I am on the Urban Ladder homepage")
    public void i_am_on_the_urban_ladder_homepage() {
        driver.get("https://www.urbanladder.com/");
    }

    @Then("I should see the Search Bar")
    public void i_should_see_the_search_bar() {
        assertTrue(searchPage.isSearchBarVisible(), "Search Bar is not visible.");
    }

    @Then("I should see the Search Button")
    public void i_should_see_the_search_button() {
        assertTrue(searchPage.isSearchButtonVisible(), "Search Button is not visible.");
    }

    @Then("I should see the Top Offers section")
    public void i_should_see_the_top_offers_section() {
        assertTrue(searchPage.isTopOffersVisible(), "Top Offers section is not visible.");
    }

    @When("I search for a product {string}")
    public void i_search_for_a_product(String product) {
        New1.searchProduct(product);
    }

    @Then("I should see search results displayed")
    public void i_should_see_search_results_displayed() {
       // assertTrue(New1.isSearchResultsDisplayed(), "Search results are not displayed.");
    }

    @Given("I am on the Product Details page") 
    public void i_am_on_the_product_details_page() {
    	driver.get("https://www.urbanladder.com/products/weston-half-leather-sofa-licorice-italian-leather?src=room");
    	//io.cucumber.java.PendingException();
    }    
   
    @Then("I should see the product details")
    public void i_should_see_the_product_details() {
        // Implement verification logic
    }

    @When("I validate the product")
    public void i_validate_the_product() {
   
    }

    @Then("I should see the image of the product")
    public void i_should_see_the_image_of_the_product() {
        // Implement verification logic
    }

    @When("I register a new user")
    public void i_register_a_new_user() {
        // Implement registration logic
    }

    @When("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        // Implement login logic
    }

    @Then("I should see my account settings")
    public void i_should_see_my_account_settings() {
        // Implement verification logic
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}