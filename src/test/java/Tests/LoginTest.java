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

    @Test
    public void usernameFieldIsVisible() {
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
    }

    @Test
    public void passwordFieldIsVisible() {
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }

   @Test
   public void logoutButtonIsVisible() {
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test
    public void userCanLoginWithValidCredentials() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        loginPage.inputUsername(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(profilePage.productsHeading.isDisplayed());
        Assert.assertEquals(profilePage.getProductsHeadingText(), "Products");
    }

    @Test
    public void userCannotLoginWithInvalidUsername() {
        loginPage.inputUsername(excelReader.getStringData("Login" , 1, 2));
        loginPage.inputPassword(excelReader.getStringData("Login", 1, 1));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }

    @Test
    public void userCannotLoginWithInvalidPassword() {
        loginPage.inputUsername(excelReader.getStringData("Login", 1, 0));
        loginPage.inputPassword(excelReader.getStringData("Login", 2, 3));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }

    @Test
    public void userCannotLoginWithBothInvalidCredentials () {
        loginPage.inputUsername(excelReader.getStringData("Login", 2, 3));
        loginPage.inputPassword(excelReader.getStringData("Login", 3, 3));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }

    @Test
    public void verifyThatUserCanLogout()  {
        loginOnProfilePage();
        sidebarPage.clickOnHamburgerMenu();
        sidebarPage.clickOnLogout();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }
}
