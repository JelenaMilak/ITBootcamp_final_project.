import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    private LoginPage loginPage;
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;



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
        homePage = new HomePage(driver,wait);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }
    //Verify that the route/login appears in the url of the page, verify is login button is clickable and load login page.

    @Test(priority = 1)
    public void isLoginUrlVisible() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn1()));

        loginPage.getLoginBtn1().click(); //Click on login button in the heder.
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
    protected void ChecksInputTypesPassword () throws InterruptedException{
        String actualResult = "password";
        String expectedResult = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult,expectedResult);
    }

    //Verify if the user can log in with valid data

    @Test(priority = 4)
    protected void loginTestWithValidCredentials() {
        String expectedResult = "My Awesome App";
        loginPage.getLoginBtn1().click();

        loginPage.login("admin@admin.com", "12345");
        loginPage.getLoginBtn().click();

        loginPage.waitUrl();
        String actualResult = loginPage.getDriver().getTitle();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    //Verify that the route/home appears in the url of the home page

    @Test(priority = 6)
    protected void isHomeUrlVisible() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/home"));
    }

    // Displays errors when user does not exist
    @Test(priority = 7 )
    protected void fakerRandomLogin(){
        loginPage.getLoginBtn1().click();
        loginPage.fakeLogin();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement closeBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div"));
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button"));

        String expectedResult = "User does not exists";
        Assert.assertTrue(closeBox.getText().contains(expectedResult));

        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/login"));

        closeBtn.click();
    }

    // Displays errors when password is wrong
    @Test( priority = 8)
    protected void wrongPassword (){
        loginPage.getLoginBtn1().click();
        loginPage.wrongPassword("789456");

        WebElement closeBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div"));
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button"));

        String expectedResult = "Wrong password";
        Assert.assertTrue(closeBox.getText().contains(expectedResult));

        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/login"));
        closeBtn.click();
    }

    /*  1.Verify that the logout button is visible on the page,
        2.Verify that the /login route appears in the url of the page,
        3.Verify that after trying to open the /home route, in the url
          page reports /login route (open with driver.get home page and check
          does it redirect you to login)
    */

    @Test (priority = 9)
    protected  void logout (){
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        loginPage.getLoginBtn().click();

        Assert.assertTrue(homePage.isLogoutBtnPresent());

        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/login"));

    }


}


















