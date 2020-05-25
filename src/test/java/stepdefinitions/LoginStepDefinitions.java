package stepdefinitions;

import common.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserTestData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import static org.junit.Assert.*;

public class LoginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    Properties dataTest= new Properties();
    public LoginStepDefinitions() {
        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(this.driver);
        try {
            String environment = System.getProperty("environment");
            Reader fReader = new FileReader(System.getProperty("user.dir")
                    +"/src/test/resources/testdata/"
                    +"data."+ environment +".properties");
            this.dataTest.load(fReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Given("^The Login page was opened$")
    public void the_login_page_was_opened() {
        this.loginPage.Open();
        this.loginPage.InitElement();
    }

    @When("^The User attempt to login with invalid credential with (.+) information$")
    public void the_user_attempt_to_login_with_invalid_credential_with_information(String user){
        UserTestData userInfo = UserTestData.Load(this.dataTest.getProperty(user));
        this.loginPage.txtEmail.sendKeys(userInfo.Email);
        this.loginPage.txtPassword.sendKeys(userInfo.Password);
        this.loginPage.btnLogin.click();
    }

    @Then("^The corresponding error message is showed for (.+)$")
    public void the_corresponding_error_message_is_showed_for(String user) {
        UserTestData userInfo = UserTestData.Load(this.dataTest.getProperty(user));
        WebDriverWait waiter = new WebDriverWait(this.driver, 30);
        WebElement lbMessage = waiter.until(ExpectedConditions.elementToBeClickable(this.loginPage.lbMessage));
        Assert.assertEquals(userInfo.Message, lbMessage.getText());
    }
}
