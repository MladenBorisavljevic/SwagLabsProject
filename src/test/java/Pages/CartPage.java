package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest {
    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "btn_secondary")
    public WebElement continueShoppingButton;

    @FindBy(css = ".btn_action.checkout_button")
    public WebElement checkoutButton;



    //---------------------------------------------------------

    public void clickOnContinueShopping() {
        continueShoppingButton.click();
    }

    public void clickOnCheckout() {
        checkoutButton.click();
    }

}
