import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    private By loginBtn = By.xpath("//*[@id='app']/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By loginBtn1 = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/a[3]");
    private By emailField = By.xpath("//*[@id='email']");
    private By passwordField = By.xpath("//*[@id='password']");
    private By singUpBtn = By.xpath("//*[@id='app']/div[1]/div/header/div/div[3]/a[4]");
    Faker faker =new Faker();
    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public WebElement getLoginBtn1() {
        return getDriver().findElement(loginBtn1);
    }

    public void setLoginBtn1(By loginBtn1) {
        this.loginBtn1 = loginBtn1;
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }



    public void setEmailField(By emailField) {
        this.emailField = emailField;
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public void setPasswordField(By passwordField) {
        this.passwordField = passwordField;
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }


    public WebElement getSingUpBtn() {
        return getDriver().findElement(singUpBtn);
    }

    public void setLoginBtn(By loginBtn) {
        this.loginBtn = loginBtn;
    }

    public void setSingUpBtn(By singUpBtn) {
        this.singUpBtn = singUpBtn;
    }

    private void loginClick(){
        getLoginBtn1().click();
    }
    public void login(String email, String password){
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getLoginBtn().click();
    }
    public void waitUrl(){
        getDriverWait().until(ExpectedConditions.urlContains("/home"));
    }
    public void waitUrlLogin(){
        getDriverWait().until(ExpectedConditions.urlContains("/login"));
    }
   public Faker getFaker(){
        return faker;
    }
    public void fakeLogin(){
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        getEmailField().click();
        getEmailField().sendKeys(email);
        getPasswordField().click();
        getPasswordField().sendKeys(password);
        getLoginBtn().click();


    }
    public void wrongPassword( String pass){
        getEmailField().sendKeys("admin@admin.com");
        getPasswordField().sendKeys(pass);
        if( pass !="12345"){
            getLoginBtn().click();
        }
    }




}
