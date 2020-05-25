package testdata;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        glue = "stepdefinitions",
        features = "src/test/resources/features/login.feature")
public class RunCucumberTest {
}
