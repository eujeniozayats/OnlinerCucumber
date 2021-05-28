package stepdefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/OpenCatalog.feature", glue = {"stepdefinitions"}, monochrome = true,
        plugin = {"pretty", "json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
