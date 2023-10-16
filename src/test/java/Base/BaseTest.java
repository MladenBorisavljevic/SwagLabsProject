package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public ExcelReader excelReader;
    public ProfilePage profilePage;
    public SidebarPage sidebarPage;
    public CartPage cartPage;
    public YourInformationPage yourInformationPage;
    public OverviewPage overviewPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage();
        excelReader = new ExcelReader("src\\test\\java\\LoginTestData.xlsx");
        profilePage = new ProfilePage();
        sidebarPage = new SidebarPage();
        cartPage = new CartPage();
        yourInformationPage = new YourInformationPage();
        overviewPage = new OverviewPage();
    }

    public void loginOnProfilePage() {
       loginPage.inputUsername(excelReader.getStringData("Login", 1, 0));
       loginPage.inputPassword(excelReader.getStringData("Login", 1, 1));
       loginPage.loginButton.click();
    }


    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
