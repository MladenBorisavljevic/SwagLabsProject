package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HamburgerTest extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test //(priority = 10)
    public void clickOnItemsShowingProducts () {
        productsPage.clickOnHamburgerMenu();
        hamburgerPage.clickOnAllItems();
        Assert.assertTrue(productsPage.productsHeading.isDisplayed());
    }

    @Test //(priority = 20)
    public void verifyThatUserCanLogout()  {
        productsPage.clickOnHamburgerMenu();
        hamburgerPage.clickOnLogout();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }
}
