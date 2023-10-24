package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
    }

    @Test (priority = 10)
    public void cartIsEmpty() {
        productsPage.clickOnCartIcon();
    }

    @Test (priority = 20)
    public void clickingOnCheckoutRedirectingToYourInformationPage() {
        cartPage.clickOnCheckout();
        Assert.assertTrue(yourInformationPage.firstNameField.isDisplayed());
        Assert.assertTrue(yourInformationPage.lastNameField.isDisplayed());
        Assert.assertTrue(yourInformationPage.postalCodeField.isDisplayed());
        Assert.assertEquals(yourInformationPage.getHeadingText(), "Checkout: Your Information");
    }

    @Test (priority = 30)
    public void clickingOnContinueShoppingRedirectsToProducts() {
        cartPage.clickOnContinueShopping();
        Assert.assertTrue(productsPage.productsHeading.isDisplayed());
        Assert.assertEquals(productsPage.getProductsHeadingText(), "Products");
    }
}
