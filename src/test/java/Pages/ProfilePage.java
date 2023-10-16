package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseTest {
    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product_label")
    public WebElement productsHeading;

    @FindBy(css = ".btn_primary.btn_inventory")
    public WebElement addToCartButton;

    @FindBy(css = ".btn_secondary.btn_inventory")
    public WebElement removeButton;

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    public WebElement cartIcon;

    //----------------------------------------------------

    public void addProduct() {
        addToCartButton.click();
    }
    public void removeProduct() {
        removeButton.click();
    }
    public String getProductsHeadingText() {
        return productsHeading.getText();
    }

    public String getCartIconNumber() {
        return cartIcon.getText();
    }
}
