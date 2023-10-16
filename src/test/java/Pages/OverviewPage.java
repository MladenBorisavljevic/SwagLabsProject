package Pages;


import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BaseTest {
    public OverviewPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn_action.cart_button")
    public WebElement finishButton;

    //------------------------------------------------------------

    public void clickOnFinish() {
        finishButton.click();
    }
}
