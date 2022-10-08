


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.devtools.v102.log.Log.clear;

public class AdminTests extends BaseTest {

    //Verify that admin button is present and url with rout :/admin/cities/

    @Test(priority = 1)
    protected void enterAdminPage() {

        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        Assert.assertTrue(homePage.isAdminBtnPresent());
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();
        String actualResult = adminPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/admin/cities"));
    }

    @Test(priority = 2)

    protected void newCity() throws InterruptedException {
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();
        adminPage.getNewItem().click();

        adminPage.getCityName().sendKeys("Luj");
        adminPage.getSaveBtn().click();

        wait.until(ExpectedConditions.visibilityOf(adminPage.getSaveBtn()));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully\nCLOSE"));

        WebElement messageBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));

        Assert.assertTrue(messageBox.getText().contains("Saved successfully"));
    }

    @Test(priority = 3)
    public void editCity() {
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();
        adminPage.getEditBtn().click();


        adminPage.getCityName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        adminPage.getCityName().sendKeys("Luj-edited");

        //wait.until(ExpectedConditions.visibilityOf(adminPage.getSaveBtn()));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully\nCLOSE"));
        WebElement messageBox = driver.findElement(By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]/span"));
        Assert.assertTrue(messageBox.getText().contains("Saved successfully"));

        profilePage.getSaveBtn().click();
    }


    @Test
    protected void searchCity() throws InterruptedException {
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();

        adminPage.searchCity();

        Thread.sleep(7000);
        String expected = driver.findElement(By.xpath(" //*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td")).getText();
        Assert.assertTrue(adminPage.getSearch().getText().contains(expected));


    }
}













