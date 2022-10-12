import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    // Set locale to ES and verify if the text appears in the header "Página de aterrizaje".
    @Test
    public void setEsLanguage() {
        dashboard.getLangBtn().click();
        dashboard.getLangBtnEs().click();
        WebElement titleElement = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult = "Página de aterrizaje";
        String actualResult = titleElement.getText();
        Assert.assertEquals(actualResult, expectedResult);

    }

    // Set locale to EN and verify if the text appears in the header "Landing".

    @Test
    public void setEnlanguage() {
        dashboard.getLangBtn().click();
        dashboard.getLangBtnEn().click();
        WebElement titleElement = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        String expectedResult = "Landing";
        String actualResult = titleElement.getText();
        Assert.assertEquals(actualResult, expectedResult);

    }

    // Set locale to FR nd verify if the text appears in the header "Page d'atterrissage".
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