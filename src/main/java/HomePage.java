import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private By homeBtn = By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[1]");
    private By logoutBtn = By.xpath(("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span"));

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }

    public void setLogoutBtn(By logoutBtn) {
        this.logoutBtn = logoutBtn;
    }

    public WebElement getHomeBtn() {
        return getDriver().findElement(homeBtn);
    }

    public void  setHomeBtn(By homeBtn) {
        this.homeBtn = homeBtn;
    }
    public boolean isLogoutBtnPresent(){
        return getLogoutBtn().isDisplayed();

    }
}
