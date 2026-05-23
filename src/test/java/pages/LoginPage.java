package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        super(driver);

        this.driver = driver;
    }

    By usernameField =
            By.name("username");

    By passwordField =
            By.name("password");

    By loginButton =
            By.xpath("//button[@type='submit']");

    By profileDropdown =
            By.xpath("//span[@class='oxd-userdropdown-tab']");

    By logoutButton =
            By.xpath("//a[contains(text(),'Logout')]");

    By errorMessage =
            By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    public void enterUsername(String username) {

        driver.findElement(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField)
                .sendKeys(password);
    }

    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }

    public void loginToApplication(
            String username,
            String password) {

        enterUsername(username);

        enterPassword(password);

        clickLoginButton();
    }

    public void clickProfileDropdown() {

        driver.findElement(profileDropdown)
                .click();
    }

    public void clickLogout() {

        driver.findElement(logoutButton)
                .click();
    }

    public String getErrorMessage() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(errorMessage));

        return driver.findElement(errorMessage)
                .getText();
    }
}