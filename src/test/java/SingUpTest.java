import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;

public class SingUpTest {
    private SingUpPage singUpPage;
    private WebDriverWait wait;
    private WebDriver driver;
    private HomePage HomePage;
    private Element element;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://vue-demo.daniel-avellaneda.com");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        singUpPage = new SingUpPage(driver, wait);
        HomePage = new HomePage(driver, wait);
        Faker faker = new Faker();

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    // Verify that the /signup route appears in the url of the page, and singUp.

    @Test(priority = 1)
    public void SingUp() {
        HomePage.getSingUpBtn().click();
        singUpPage.SingUp();
        String actualResult = singUpPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/signup"));

    }

    @Test(priority = 2)
    protected void CheckInputType() {
        HomePage.getSingUpBtn().click();
        singUpPage.SingUp();

        String actualResult1 = "email";
        String expectedResult1 = singUpPage.getEmail().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);

        String actualResult2 = "password";
        String expectedResult2 = singUpPage.getPassword().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);

    }

    //Displays errors when user already exists
    @Test
    protected void AlreadyUser() {

        HomePage.getSingUpBtn().click();
        singUpPage.SingUp();
        driver.navigate().refresh();
        singUpPage.AlreadyUser("Test Test", "admin@admin.com", "123654", "123654");
        singUpPage.getSingBtn().click();

        WebElement closeBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));

        String expectedResult = "E-mail already exists";
        Assert.assertTrue(closeBox.getText().contains(expectedResult));
        closeBox.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }


    }
}
