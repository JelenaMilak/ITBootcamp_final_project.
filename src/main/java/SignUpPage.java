import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {
    private By closeBtn = By.xpath("//*[@id='app']/div[4]/div/div/div[3]/button/span");
    private By importantBox = By.xpath("//*[@id='app']/div[4]/div/div");
    private By emailMessageBox = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");
    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By singBtn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span");
    private By sinbBtnDown = By.xpath("//<button type='submit'class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default secondary'><span class='v-btn__content'>Sign me up</span></button>");

    Faker faker = new Faker();

    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getCloseBtn() {
        return getDriver().findElement(closeBtn);
    }

    public WebElement getSinbBtnDown() {
        return getDriver().findElement(sinbBtnDown);
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

    public void SingUp() {
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

    public void AlreadyUser(String name, String email, String password, String confirmpassword) {
        getName().sendKeys("Test Test");
        getEmail().sendKeys("admin@admin.com");
        getPassword().sendKeys("123654");
        getConfirmPassword().sendKeys("123654");
        getSingBtn().click();

    }

    public boolean isEmailMessageBoxPresent() {
        return getEmailMessageBox().isDisplayed();

    }

    public void SingUpfakerVerification(String name, String email, String password, String confirmpassword) {
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        name = faker.internet().domainName();
        getName().click();
        getName().sendKeys(name);
        getEmail().click();
        getEmail().sendKeys(email);
        getPassword().click();
        getPassword().sendKeys(password);
        getConfirmPassword().click();
        getConfirmPassword().sendKeys(password);
        getSingBtn().click();
    }
}
