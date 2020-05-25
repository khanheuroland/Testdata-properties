package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    @FindBy(css = "div.login-form input[type=\"email\"]")
    public WebElement txtEmail;

    @FindBy(css = "div.login-form input[type=\"password\"]")
    public WebElement txtPassword;

    @FindBy(css = "div.login-form button")
    public WebElement btnLogin;

    public By lbMessage = By.cssSelector("div.modal .body-message b");

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void InitElement()
    {
        PageFactory.initElements(this.driver, this);
    }

    public void Open()
    {
        this.driver.get("http://www.testmaster.vn/admin");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


}
