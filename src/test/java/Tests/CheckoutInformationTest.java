package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutInformationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/checkout-step-one.html");
    }


    @Test (priority = 10)
    public void userCanProceedToOverview() {
        yourInformationPage.inputFirstName("Petar");
        yourInformationPage.inputLastName("Petrovic");
        yourInformationPage.inputPostalCode("11000");
        yourInformationPage.clickOnContinue();
        Assert.assertTrue(overviewPage.finishButton.isDisplayed());
    }

    @Test (priority = 20)
    public void userCannotProceedWithEmptyFirstName() {
        yourInformationPage.inputFirstName("");
        yourInformationPage.inputLastName("Petrovic");
        yourInformationPage.inputPostalCode("11000");
        yourInformationPage.clickOnContinue();
        Assert.assertTrue(yourInformationPage.errorButton.isDisplayed());
    }

    @Test (priority = 30)
    public void userCannotProceedWithEmptyLastName() {
        yourInformationPage.inputFirstName("Petar");
        yourInformationPage.inputLastName("");
        yourInformationPage.inputPostalCode("11000");
        yourInformationPage.clickOnContinue();
        Assert.assertTrue(yourInformationPage.errorButton.isDisplayed());
    }

    @Test (priority = 40)
    public void userCannotProceedWithEmptyPostalCode() {
        yourInformationPage.inputFirstName("Petar");
        yourInformationPage.inputLastName("Petrovic");
        yourInformationPage.inputPostalCode("");
        yourInformationPage.clickOnContinue();
        Assert.assertTrue(yourInformationPage.errorButton.isDisplayed());
    }

}
