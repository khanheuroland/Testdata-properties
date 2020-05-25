package testdata;

import common.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
    @After
    public void After(Scenario scenario)
    {
        DriverManager.closeWebDriver();
    }
}
