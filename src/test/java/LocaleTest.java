import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {
    @Test
    public void setEsLanguage() {
        dashboard.getLangBtn().click();
        dashboard.getLangBtnEs().click();
        WebElement titleElement = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult = "Página de aterrizaje";
        String actualResult = titleElement.getText();
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void setEnlanguage() {
        dashboard.getLangBtn().click();
        dashboard.getLangBtnEn().click();
        WebElement titleElement = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult = "Landing";
        String actualResult = titleElement.getText();
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void setFrlanguage() {
        dashboard.getLangBtn().click();
        dashboard.getLangBtnFr().click();
        WebElement titleElement = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult = "Page d'atterrissage";
        String actualResult = titleElement.getText();
        Assert.assertEquals(actualResult, expectedResult);


    }
}