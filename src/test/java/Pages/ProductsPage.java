package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BaseTest {

    public String productsURL = "https://www.saucedemo.com/v1/inventory.html";
    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bm-burger-button")
    public WebElement hamburgerMenu;
    @FindBy(className = "product_label")
    public WebElement productsHeading;

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18.fa-3x ")
    public WebElement cartIcon;

    @FindBy(css = ".shopping_cart_link.fa-layers.fa-fw")
    public WebElement cartIconNumber;

    @FindBy(css = ".btn_primary.btn_inventory")
    public List<WebElement>addToCartButtons;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> productsNames;

    @FindBy(className = "inventory_item_img")
    public List<WebElement>productsImages;

    @FindBy(css = ".btn_secondary.btn_inventory")
    public List<WebElement>removeButtons;

    @FindBy(className = "product_sort_container")
    public WebElement productsSortButton;

    //----------------------------------------------------

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }

    public String getProductsHeadingText() {
        return productsHeading.getText();
    }
    public void clickOnAddToCart(int i) {
        addToCartButtons.get(i).click();
    }
    public void clickOnRemoveButton(int i) {
        removeButtons.get(i).click();
    }

    public String getCartIconNumber() {
        return cartIconNumber.getText();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void clickOnProductSortButton() {
        productsSortButton.click();
    }

    public void clickOnProductName(String name) {
        for (int i = 0; i < productsNames.size() ; i++) {
            if(productsNames.get(i).getText().equalsIgnoreCase(name))
                productsNames.get(i).click();
            break;
        }
    }

    public boolean areProductsSortedAscendingByTitles(List<WebElement>elements) {
        List<String>titles = new ArrayList<>();
        for(WebElement element : elements) {
            String title = element.getText();
            titles.add(title);
        }
        for (int i = 0; i < titles.size() - 1 ; i++) {
            String current = titles.get(i);
            String next = titles.get(i + 1);
            if(current.compareToIgnoreCase(next) > 0)
                return false;
        }
        return true;
    }

    public boolean areProductsSortedDesccendingByTitles(List<WebElement>elements) {
        List<String>titles = new ArrayList<>();
        for(WebElement element : elements) {
            String title = element.getText();
            titles.add(title);
        }
        for (int i = 0; i < titles.size() - 1 ; i++) {
            String current = titles.get(i);
            String next = titles.get(i + 1);
            if(current.compareToIgnoreCase(next) < 0)
                return false;
        }
        return true;
    }

}
