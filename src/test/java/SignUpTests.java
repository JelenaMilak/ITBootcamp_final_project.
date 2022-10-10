
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

    // Verify that the /signup route appears in the url of the page, and singUp.

    @Test
    public void SingUp() {
        homePage.getSingUpBtn().click();
        singUpPage.SingUp();
        String actualResult = singUpPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/signup"));

    }

    @Test
    protected void CheckInputType() {
        homePage.getSingUpBtn().click();
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

        homePage.getSingUpBtn().click();
        singUpPage.SingUp();
        driver.navigate().refresh();
        singUpPage.AlreadyUser("Test Test", "admin@admin.com", "123654", "123654");
        singUpPage.getSingBtn().click();

        WebElement closeBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));

        String expectedResult = "E-mail already exists";
        Assert.assertTrue(closeBox.getText().contains(expectedResult));
        closeBox.click();

    }

    @Test
    protected void singUpVerification() {

        homePage.getSingUpBtn().click();
        singUpPage.SingUp();
        driver.navigate().refresh();
        singUpPage.SingUpfakerVerification("name", "email", "password", "password");

        wait.until(ExpectedConditions.visibilityOf(singUpPage.getImportantBox()));
        wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div/div[4]/div/div/div[1]"),
                "IMPORTANT: Verify your account"));

        WebElement importantBox = driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div[1]"));
        String expectedResult = "IMPORTANT: Verify your account";

        Assert.assertTrue(importantBox.getText().contains(expectedResult));
        singUpPage.getCloseBtn().click();

    }

}
