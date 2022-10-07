import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    protected LoginPage loginPage;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected SingUpPage singUpPage;
    protected AdminPage adminPage;
    protected Dashboard dashboard;
    protected ProfilePage profilePage;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Faker faker = new Faker();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        loginPage = new LoginPage(driver, wait);
        homePage = new HomePage(driver, wait);
        singUpPage = new SingUpPage(driver, wait);
        adminPage = new AdminPage(driver, wait);
        dashboard = new Dashboard(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {


    }
}
