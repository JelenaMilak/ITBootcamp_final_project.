


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

    @Test
    protected void enterAdminPage() {

        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        Assert.assertTrue(homePage.isAdminBtnPresent());
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();
        String actualResult = adminPage.getDriver().getCurrentUrl();
        Assert.assertTrue(actualResult.endsWith("/admin/cities"));
    }

    // Create new city and verify that the message contains text "Saved successfully".

    @Test

    protected void newCity() throws InterruptedException {
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();
        adminPage.getNewItem().click();

        adminPage.getCityName().sendKeys("Mordor");
        adminPage.getSaveBtn().click();

        wait.until(ExpectedConditions.visibilityOf(adminPage.getSaveBtn()));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully\nCLOSE"));

        WebElement messageBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));

        Assert.assertTrue(messageBox.getText().contains("Saved successfully"));
    }

    // Edit the city from the previous test and verify that the message contains text "Saved successfully".

    @Test
    public void editCity() throws InterruptedException {

        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();
        String myCity = "Mordor";

        adminPage.getSearch().sendKeys(myCity);
        wait.until(ExpectedConditions.visibilityOf(adminPage.getEditBtn()));
        adminPage.getEditBtn().click();
        adminPage.getCityName().sendKeys("Mordor-edited");

        wait.until(ExpectedConditions.visibilityOf(adminPage.getSaveBtn()));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully\nCLOSE"));

        adminPage.getSaveBtn().click();


    }


    @Test
    protected void searchCity() throws InterruptedException {
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();

        adminPage.searchCity();

        WebElement search = driver.findElement(By.id("search"));
        search.clear();
        WebElement city = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
        search.sendKeys(city.getText());
        Assert.assertTrue(city.isDisplayed());
    }


    @Test
    public void deleteCity() throws InterruptedException {
        loginPage.getLoginBtn1().click();
        loginPage.login("admin@admin.com", "12345");
        homePage.getAdminBtn().click();
        adminPage.getCityBtn().click();

        WebElement city = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]"));
        WebElement search = driver.findElement(By.id("search"));
        search.clear();
        search.sendKeys(city.getText());

        WebElement delete = driver.findElement(By.xpath("//*[@id=\"delete\"]/span"));
        delete.click();

        WebElement deleteDialog = driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span"));
        deleteDialog.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        WebElement message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(message.getText().contains("Deleted successfully"));


    }


}












