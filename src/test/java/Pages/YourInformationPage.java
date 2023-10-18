package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage extends BaseTest {
    public YourInformationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(className = "subheader")
    public WebElement yourInformationHeading;

    @FindBy(css = ".btn_primary.cart_button")
    public WebElement continueButton;

    @FindBy(className = "error-button")
    public WebElement errorButton;

    @FindBy(css = ".cart_cancel_link.btn_secondary")
    public WebElement cancelButton;

    //-------------------------------------------------------------

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    public String getHeadingText() {
        return yourInformationHeading.getText();
    }

    public void clickOnContinue() {
        continueButton.click();
    }

    public void clickOnCancel() {
        cancelButton.click();
    }

}
