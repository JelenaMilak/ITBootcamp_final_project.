import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {


    //Verify that the route/login appears in the url of the page, verify is login button is clickable and load login page.

    @Test
    public void isLoginUrlVisible() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn1()));

        loginPage.getLoginBtn1().click(); //Click on login button in the heder.
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = loginPage.getDriver().getCurrentUrl();

        Assert.assertTrue(actualResult.endsWith("/login"));
    }

    //Verify that the email input field for the type attribute has a value e-mail.

    @Test
    public void ChecksInputTypesEmail() throws InterruptedException {
        String actualResult = "email";
        String expectedResult = loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResult, expectedResult);
    }

    //Verify that the password input field for the type attribute has a value password

    @Test
    protected void ChecksInputTypesPassword() throws InterruptedException {
        String actualResult = "password";
        String expectedResult = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult, expectedResult);
    }

    //Verify if the user can log in with valid data

    @Test
    protected void loginTestWithValidCredentials() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn1()));
        String expectedResult = "My Awesome App";
        loginPage.getLoginBtn1().click();

        loginPage.login("admin@admin.com", "12345");

        loginPage.getLoginBtn().click();

        loginPage.waitUrl();
        String actualResult = loginPage.getDriver().getTitle();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    //Verify that the route/home appears in the url of the home page

    @Test
    protected void isHomeUrlVisible() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn1()));
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        loginPage.getLoginBtn().click();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/home"));
        loginPage.getLogoutBtn().click();
    }

    // Displays errors when user does not exist

    @Test

    protected void fakerRandomLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn1()));
        loginPage.getLoginBtn1().click();
        loginPage.fakeLogin();

        WebElement closeBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div"));
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/button"));

        String expectedResult = "User does not exists";
        Assert.assertTrue(closeBox.getText().contains(expectedResult));

        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/login"));

        closeBtn.click();

    }

    // Displays errors when password is wrong.

    @Test
    protected void wrongPassword() {

        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "121233");


        loginPage.getLoginBtn().click();

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

    @Test
    protected void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn1()));
        loginPage.getLoginBtn1().click();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.login("admin@admin.com", "12345");

        loginPage.checkLogout();

        Assert.assertTrue(homePage.isLogoutBtnPresent());
        loginPage.getLogoutBtn().click();

        String actualResult = "https://vue-demo.daniel-avellaneda.com/home";
        Assert.assertTrue(actualResult.endsWith("/home"));


    }


}


















