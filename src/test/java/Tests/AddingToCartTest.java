package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void userCanAddProduct() {
        profilePage.addProduct();
        Assert.assertEquals(profilePage.getCartIconNumber(), "1");
    }

    @Test
    public void userCanRemoveProduct() throws InterruptedException {
        profilePage.addProduct();
        profilePage.removeProduct();
        Assert.assertTrue(profilePage.addToCartButton.isDisplayed());
    }
}
