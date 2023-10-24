package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }

    @Test (priority = 10)
    public void elementsAreDisplayed() {
        Assert.assertTrue(loginPage.elementIsDisplayed(loginPage.usernameField));
        Assert.assertTrue(loginPage.elementIsDisplayed(loginPage.passwordField));
        Assert.assertTrue(loginPage.elementIsDisplayed(loginPage.loginButton));
    }

    @Test (priority = 20)
    public void userCanLoginWithValidCredentials() {
        loginOnAccount();
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.productsURL);
        Assert.assertTrue(productsPage.productsHeading.isDisplayed());
        Assert.assertEquals(productsPage.getProductsHeadingText(), "Products");
    }

    @Test (priority = 30)
    public void userCannotLoginWithInvalidUsername() throws InterruptedException {
        loginPage.inputUsername(excelReader.getStringData("Login" , 1, 2));
        loginPage.inputPassword(excelReader.getStringData("Login", 1, 1));
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test (priority = 40)
    public void userCannotLoginWithInvalidPassword() throws InterruptedException {
        loginPage.inputUsername(excelReader.getStringData("Login", 1, 0));
        loginPage.inputPassword(excelReader.getStringData("Login", 2, 3));
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test (priority = 50)
    public void userCannotLoginWithBothInvalidCredentials () throws InterruptedException {
        loginPage.inputUsername(excelReader.getStringData("Login", 2, 3));
        loginPage.inputPassword(excelReader.getStringData("Login", 3, 3));
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test (priority = 60)
    public void verifyThatUserCanLogout() throws InterruptedException {
        loginOnAccount();
        productsPage.clickOnHamburgerMenu();
        hamburgerPage.clickOnLogout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }
}
