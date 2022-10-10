import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage {

    private By myCity = By.xpath("//*[@id='app']/div[5]/div/div/div[3]/button[2]/span");
    private By messageBox = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    private By search = By.id("search");
    private By editBitn = By.xpath("//*[@id='edit']/span");

    private By saveBtn = By.xpath("/html/body/div/div[5]/div/div/div[3]/button[2]");
    private By newItem = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span");
    private By cityName = By.xpath("//*[@id='name']");
    private By adminBtn = By.xpath("//*[@id='edit']/span/i");
    private By cityBtn = By.xpath("//*[@id='list-item-117']");
    private By userBtn = By.xpath("//*[@id='list-item-143']");
    private By leftArrow = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[3]/div[3]");
    private By rightArrow = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div[3]/div[4]");


    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getMyCity() {
        return getDriver().findElement(myCity);
    }


    public WebElement getMessageBox() {
        return getDriver().findElement(messageBox);
    }

    public WebElement getEditBtn() {
        return getDriver().findElement(editBitn);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public void setSaveBtn(By saveBtn) {
        this.saveBtn = saveBtn;
    }

    public WebElement getNewItem() {
        return getDriver().findElement(newItem);
    }

    public WebElement getCityName() {
        return getDriver().findElement(cityName);
    }

    public void setNewItem(By newItem) {
        this.newItem = newItem;
    }

    public void setCityName(By cityName) {
        this.cityName = cityName;
    }

    public WebElement getAdminBtn() {
        return getDriver().findElement(adminBtn);
    }

    public WebElement getCityBtn() {
        return getDriver().findElement(cityBtn);
    }

    public WebElement getUserBtn() {
        return getDriver().findElement(userBtn);
    }

    public WebElement getLeftArrow() {
        return getDriver().findElement(leftArrow);
    }

    public WebElement getRightArrow() {
        return getDriver().findElement(rightArrow);
    }

    public WebElement getSearch() {
        return getDriver().findElement(search);
    }

    public void searchCity() {
        getSearch().click();
        getSearch().sendKeys("Morinj editedhophop");


    }


    public void searchMethod(String s) {
        getAdminBtn().click();
        getEditBtn().click();
        getMyCity().click();
        getMyCity().sendKeys("Bahami");
    }
}
