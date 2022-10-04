import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPage1 {
    private LoginPage loginPage;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        loginPage = new LoginPage(driver, wait);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }
    //Verify that the route/login appears in the url of the page, verify is login button is clickable and load login page.

    @Test(priority = 1)
    public void isLoginUrlVisible() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn1()));
        loginPage.getLoginBtn1().click();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/login"));
    }

    //Verify that the email input field for the type attribute has a value e-mail.

    @Test(priority = 2)
    public void ChecksInputTypesEmail () throws InterruptedException{
        String actualResult = "email";
        String expectedResult = loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResult,expectedResult);
    }

    //Verify that the password input field for the type attribute has a value password

    @Test(priority = 3)
    public void ChecksInputTypesPassword () throws InterruptedException{
        String actualResult = "password";
        String expectedResult = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult,expectedResult);
    }

    //Verify if the user can log in with valid data

    @Test(priority = 4)
    public void loginTestWithValidCredentials() {
        String expectedResult = "My Awesome App";
        loginPage.getLoginBtn1().click();

        loginPage.login("admin@admin.com", "12345");
        loginPage.getLoginBtn().click();
        loginPage.waitUrl();

        String actualResult = loginPage.getDriver().getTitle();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }



}







