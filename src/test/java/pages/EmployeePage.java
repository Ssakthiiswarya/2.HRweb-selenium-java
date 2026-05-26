package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeePage extends BasePage {

    WebDriver driver;

    public EmployeePage(WebDriver driver) {

        super(driver);

        this.driver = driver;
    }

    By pimMenu =
            By.xpath("//span[text()='PIM']");

    By addEmployeeButton =
            By.xpath("//a[text()='Add Employee']");

    By firstName =
            By.name("firstName");

    By lastName =
            By.name("lastName");

    By saveButton =
            By.xpath("//button[@type='submit']");

    By employeeName =
            By.xpath("//h6[text()='Personal Details']");

    public void clickPimMenu() {

        driver.findElement(pimMenu)
                .click();
    }

    public void clickAddEmployee() {

        driver.findElement(addEmployeeButton)
                .click();
    }

    public void enterFirstName(String fname) {

        driver.findElement(firstName)
                .sendKeys(fname);
    }

    public void enterLastName(String lname) {

        driver.findElement(lastName)
                .sendKeys(lname);
    }

    public void clickSaveButton() {

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

            e.printStackTrace();
        }

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(saveButton)
        );
    }

    public void addEmployee(
            String fname,
            String lname) {

        clickPimMenu();

        clickAddEmployee();

        enterFirstName(fname);

        enterLastName(lname);

        clickSaveButton();
    }

    public String getEmployeePageText() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(15));

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(employeeName));

        return driver.findElement(employeeName)
                .getText();
    }
}