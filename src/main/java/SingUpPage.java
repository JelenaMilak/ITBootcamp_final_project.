import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPage extends BasePage{
    private By importantBox = By.xpath("//*[@id='app']/div[4]/div/div");
    private By emailMessageBox = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");
    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By singBtn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span");
    Faker faker = new Faker();
    public SingUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getImportantBox() {
        return getDriver().findElement(importantBox);
    }

    public void setImportantBox(By importantBox) {
        this.importantBox = importantBox;
    }

    public WebElement getEmailMessageBox() {
        return getDriver().findElement(emailMessageBox);
    }

    public void setEmailMessageBox(By emailMessageBox) {
        this.emailMessageBox = emailMessageBox;
    }

    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getSingBtn() {
        return getDriver().findElement(singBtn);
    }


    public void setName(By name) {
        this.name = name;
    }

    public void setEmail(By email) {
        this.email = email;
    }

    public void setPassword(By password) {
        this.password = password;
    }

    public void setConfirmPassword(By confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setSingBtn(By singBtn) {
        this.singBtn = singBtn;
    }
    public void SingUp(){
        String name = faker.internet().domainName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        getName().click();
        getName().sendKeys(name);
        getEmail().click();
        getEmail().sendKeys(email);
        getPassword().click();
        getPassword().sendKeys(password);
        getConfirmPassword().click();
        getConfirmPassword().sendKeys(password);
        getSingBtn();
    }
    public void AlreadyUser(String name, String email, String password, String confirmpassword){
        getName().sendKeys("Test Test");
        getEmail().sendKeys("admin@admin.com");
        getPassword().sendKeys("123654");
        getConfirmPassword().sendKeys("123654");
        getSingBtn().click();

    }
    public boolean isEmailMessageBoxPresent(){
        return getEmailMessageBox().isDisplayed();

    }
    public void SingUpVerification(String name, String email, String password, String confirmpassword){
        getName().sendKeys("Milakovic");
        getEmail().sendKeys("milakovic@itbootcamp.rs");
        getPassword().sendKeys("123456");
        getConfirmPassword().sendKeys("123456");
        getSingBtn().click();
    }
}
