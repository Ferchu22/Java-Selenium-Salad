package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)   // this is a Cucumber´s annotation used to run tests
@CucumberOptions(   // this is going to configure cucumber
        features = "src/test/resources/features",   // shows the file path where feature files are located
        glue = {"stepdefinitions"}, // is what associates the step definitions with the steps in feature files
        plugin = {"pretty", "html:target/cucumber-reports.html"}, // this is used for a pretty readable report with html
        monochrome = true  // if we want color or not on the report
)
public class TestRunner {
}

