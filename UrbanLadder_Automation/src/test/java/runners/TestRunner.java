package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"} // Generate JSON report
)
public class TestRunner extends AbstractTestNGCucumberTests {
}