package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }


    @Test(priority = 10)
    public void userCanAddProduct() {
        productsPage.clickOnAddToCart(0);
        Assert.assertEquals(productsPage.getCartIconNumber(), "1");
        productsPage.clickOnRemoveButton(0);
    }

    @Test(priority = 20)
    public void userCanRemoveProduct() {
        productsPage.clickOnAddToCart(1);
        productsPage.clickOnRemoveButton(0);
        Assert.assertTrue(productsPage.getCartIconNumber().isEmpty());
    }

    @Test(priority = 30)
    public void productIsStillInTheCartAfterLogout() {
        productsPage.clickOnAddToCart(2);
        productsPage.clickOnHamburgerMenu();
        hamburgerPage.clickOnLogout();
        loginOnAccount();
        Assert.assertEquals(productsPage.getCartIconNumber(), "1");
        productsPage.clickOnRemoveButton(0);
    }

    @Test (priority = 40)
    public void verifySortButtonFunctionalityByTitles() {
        Select objSelect = new Select(productsPage.productsSortButton);
        objSelect.selectByVisibleText("Name (A to Z)");
        Assert.assertTrue(productsPage.areProductsSortedAscendingByTitles(productsPage.productsNames));
        objSelect.selectByVisibleText("Name (Z to A)");
        Assert.assertTrue(productsPage.areProductsSortedDesccendingByTitles(productsPage.productsNames));
    }

}





