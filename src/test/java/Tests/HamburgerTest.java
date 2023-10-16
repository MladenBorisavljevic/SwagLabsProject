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

    @Test
    public void clickOnItemsShowingProducts () {
        sidebarPage.clickOnHamburgerMenu();
        sidebarPage.clickOnAllItems();
        Assert.assertTrue(profilePage.productsHeading.isDisplayed());
    }

    @Test
    public void verifyThatUserCanLogout()  {
        sidebarPage.clickOnHamburgerMenu();
        sidebarPage.clickOnLogout();
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertTrue(loginPage.usernameField.isDisplayed());
        Assert.assertTrue(loginPage.passwordField.isDisplayed());
    }
}
