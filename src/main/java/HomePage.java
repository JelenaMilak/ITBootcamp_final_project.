import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private By adminBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/button[1]");
    private By homeBtn = By.xpath("//*[@id='app']/div/div/header/div/div[3]/a[1]");
    private By logoutBtn = By.xpath(("//*[@id='app']/div[1]/div/header/div/div[3]/button[2]/span"));
    private By singUpBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/a[4]/span");
    private By profileBtn = By.xpath(" //*[@id='app']/div[1]/div/header/div/div[3]/a[3]");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }

    public WebElement getProfileBtn() {
        return getDriver().findElement(profileBtn);
    }

    public WebElement getSingUpBtn() {
        return getDriver().findElement(singUpBtn);
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }

    public boolean isLogoutBtnPresent(){
        return getLogoutBtn().isDisplayed();
    }
    public boolean isAdminBtnPresent(){
        return getAdminBtn().isDisplayed();
    }
}
