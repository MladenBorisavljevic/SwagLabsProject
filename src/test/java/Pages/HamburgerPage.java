package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenu extends BaseTest {
    public HamburgerMenu() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bm-burger-button")
    public WebElement hamburgerMenu;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsButton;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState;

    //---------------------------------------------------------

    public void clickOnAllItems() {
        allItemsButton.click();
    }

    public void  clickOnAbout() {
        aboutButton.click();
    }

    public void clickOnLogout() {
        logoutButton.click();
    }

    public void clickOnResetAppState() {
        resetAppState.click();
    }

    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }




}
