package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginToApplication(
                ConfigReader.getUsername(),
                ConfigReader.getPassword()
        );

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertEquals(
                currentUrl,
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
        );
    }

    @Test
    public void verifyInvalidLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginToApplication(
                "wronguser",
                "wrongpass"
        );

        String error =
                loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains(
                        "Invalid credentials"
                )
        );
    }

    @Test
    public void verifyLogoutTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginToApplication(
                ConfigReader.getUsername(),
                ConfigReader.getPassword()
        );

        loginPage.clickProfileDropdown();

        loginPage.clickLogout();

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("login")
        );
    }
}