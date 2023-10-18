package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/checkout-step-two.html");
    }

    @Test //(priority = 10)
    public void userCanCompleteTheOrder() {
        overviewPage.clickOnFinish();
        Assert.assertTrue(orderCreatedPage.orderThanks.isDisplayed());
        Assert.assertTrue(orderCreatedPage.orderDone.isDisplayed());
        Assert.assertEquals(orderCreatedPage.getOrderThanksMessage(), "THANK YOU FOR YOUR ORDER");
    }
}
