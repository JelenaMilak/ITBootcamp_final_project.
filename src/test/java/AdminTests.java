

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTests extends BaseTest {

    //Verify that admin button is present and url with rout :/admin/cities/

    @Test(priority = 1)
    protected void enterAdminPage (){

        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com","12345");
        Assert.assertTrue(homePage.isAdminBtnPresent());
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();
        String actualResult = adminPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/admin/cities"));
    }
    @Test( priority = 2)
    protected void newCity (){
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com","12345");
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();
        adminPage.getNewItem().click();

        wait.until(ExpectedConditions.elementToBeClickable(adminPage.getCityName()));
        adminPage.getCityName().sendKeys("M");
        adminPage.getSaveBtn().click();

        WebElement messageBox = driver.findElement(By.xpath("//*[@id='app']/div[1]main/div/div[2]div/div/[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(messageBox.getText().contains("Saved successfully"));

    }
    @Test
    protected void editCity(){

    }





}










