package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCreatedPage extends BaseTest {
    public OrderCreatedPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-header")
    public WebElement orderThanks;

    @FindBy(className = "complete-text")
    public WebElement orderDone;

    //----------------------------------------------------------

    public String getOrderThanksMessage() {
        return orderThanks.getText();
    }

    public String getOrderDoneMessage() {
        return orderThanks.getText();
    }


}
