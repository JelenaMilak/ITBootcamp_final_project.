
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;


public class BaseTest {
    protected LoginPage loginPage;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected SignUpPage singUpPage;
    protected AdminPage adminPage;
    protected MainPage dashboard;
    protected ProfilePage profilePage;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        loginPage = new LoginPage(driver, wait);
        homePage = new HomePage(driver, wait);
        singUpPage = new SignUpPage(driver, wait);
        adminPage = new AdminPage(driver, wait);
        dashboard = new MainPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().deleteAllCookies();
    }


    @AfterClass
    public void afterClass() {
        driver.quit();

    }
}
