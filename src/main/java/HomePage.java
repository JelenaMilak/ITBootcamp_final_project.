import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private By homeBtn = By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[1]");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getHomeBtn() {
        return homeBtn;
    }

    public void setHomeBtn(By homeBtn) {
        this.homeBtn = homeBtn;
    }
}
