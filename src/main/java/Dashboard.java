import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard extends BasePage{
    private By langBtn = By.xpath(("//*[@id='app']/div[1]/div/header/div/div[3]/button/span"));
    private By langBtnEs = By.xpath("//*[@id='list-item-75']");
    private By langBtnEn = By.xpath("//*[@id='list-item-73']/div");
    private By langBtnFr = By.xpath("//*[@id='list-item-77']/div");
    public Dashboard(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLangBtn() {
        return getDriver().findElement(langBtn);
    }

    public WebElement getLangBtnFr() {
        return getDriver().findElement(langBtnFr);
    }

    public WebElement getLangBtnEs() {
        return getDriver().findElement(langBtnEs);
    }

    public WebElement getLangBtnEn() {
        return getDriver().findElement(langBtnEn);
    }
}

