import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTest extends BaseTest{
    @Test
    public void editProfileTest(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        homePage.getSingUpBtn().click();
        singUpPage.SingUp();
        driver.navigate().refresh();
        singUpPage.SingUpfakerVerification("name","email","password","password");
        singUpPage.getCloseBtn().click();

        homePage.getProfileBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(profilePage.getContry()));

        profilePage.editFakerProfile("name","phone","city","contry","twiter","github");



    }
}
