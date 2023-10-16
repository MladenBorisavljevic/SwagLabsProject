package Tests;

import Base.BaseTest;
import Pages.YourInformationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
    }

    @Test
    public void clickingOnCheckoutRedirectingToYourInformationPage() {
        cartPage.clickOnCheckout();
        Assert.assertTrue(yourInformationPage.firstNameField.isDisplayed());
        Assert.assertTrue(yourInformationPage.lastNameField.isDisplayed());
        Assert.assertTrue(yourInformationPage.postalCodeField.isDisplayed());
        Assert.assertEquals(yourInformationPage.getHeadingText(), "Checkout: Your Information");
    }

    @Test
    public void userCanProceedToOverview() {
        cartPage.clickOnCheckout();
        yourInformationPage.inputFirstName("Petar");
        yourInformationPage.inputLastName("Petrovic");
        yourInformationPage.inputPostalCode("11000");
        yourInformationPage.clickOnContinue();
        Assert.assertTrue(overviewPage.finishButton.isDisplayed());
    }

    @Test
    public void userCannotProceedWithEmptyFirstName() {
        cartPage.clickOnCheckout();
        yourInformationPage.inputFirstName("");
        yourInformationPage.inputLastName("Petrovic");
        yourInformationPage.inputPostalCode("11000");
        yourInformationPage.clickOnContinue();
        Assert.assertTrue(yourInformationPage.errorButton.isDisplayed());
    }

    @Test
    public void userCannontProceedWithEmptyLastName() {
        cartPage.clickOnCheckout();
        yourInformationPage.inputFirstName("Petar");
        yourInformationPage.inputLastName("");
        yourInformationPage.inputPostalCode("11000");
        yourInformationPage.clickOnContinue();
        Assert.assertTrue(yourInformationPage.errorButton.isDisplayed());
    }

    @Test
    public void userCannotProceedWithEmptyPostalCode() {
        cartPage.clickOnCheckout();
        yourInformationPage.inputFirstName("Petar");
        yourInformationPage.inputLastName("Petrovic");
        yourInformationPage.inputPostalCode("");
        yourInformationPage.clickOnContinue();
        Assert.assertTrue(yourInformationPage.errorButton.isDisplayed());
    }
}
