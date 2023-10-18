package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public ExcelReader excelReader;
    public ProductsPage productsPage;
    public HamburgerPage hamburgerPage;
    public CartPage cartPage;
    public YourInformationPage yourInformationPage;
    public OverviewPage overviewPage;
    public OrderCreatedPage orderCreatedPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage();
        excelReader = new ExcelReader("src\\test\\java\\LoginTestData.xlsx");
        productsPage = new ProductsPage();
        hamburgerPage = new HamburgerPage();
        cartPage = new CartPage();
        yourInformationPage = new YourInformationPage();
        overviewPage = new OverviewPage();
        orderCreatedPage = new OrderCreatedPage();

    }

    public void loginOnAccount() {
       loginPage.inputUsername(excelReader.getStringData("Login", 1, 0));
       loginPage.inputPassword(excelReader.getStringData("Login", 1, 1));
       loginPage.loginButton.click();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public boolean elementIsDisplayed(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isDisplayed;
    }


    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

   @AfterClass
   public void killProcesses() throws IOException {
       //Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
    }
}
