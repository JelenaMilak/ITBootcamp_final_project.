import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTest extends BaseTest{
    @Test
    public void editProfileTest() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        homePage.getSingUpBtn().click();
        singUpPage.SingUp();
        driver.navigate().refresh();
        singUpPage.SingUpfakerVerification("name","email","password","password");
        singUpPage.getCloseBtn().click();

        homePage.getProfileBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(profilePage.getContry()));
        Thread.sleep(500);

        profilePage.editFakerProfile("name","phone","city","contry","twiter","github","arrow");

        WebElement succMsg = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div"));
        String expectedResult ="Profile saved successfuly";
        Assert.assertTrue(succMsg.getText().contains(expectedResult));


    }
}
