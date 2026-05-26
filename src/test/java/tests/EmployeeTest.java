package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import utilities.ConfigReader;

public class EmployeeTest extends BaseTest {

    @Test
    public void verifyAddEmployeeTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginToApplication(
                ConfigReader.getUsername(),
                ConfigReader.getPassword()
        );

        EmployeePage employeePage =
                new EmployeePage(driver);

        employeePage.addEmployee(
                "Ishu",
                "Sakthi"
        );

        String currentUrl =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("pim")
        );
    }
}