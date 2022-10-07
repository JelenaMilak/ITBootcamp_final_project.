import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    Faker faker = new Faker();
    private By email = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[1]");
    private By name = By.xpath("//*[@id='name']");
    private By phone = By.xpath("//*[@id='phone']");
    private By city = By.xpath("//*[@id='city']");
    private By contry = By.xpath("//*[@id='country']");
    private By twiter = By.xpath("//*[@id='urlTwitter']");
    private By gitHub = By.xpath("//*[@id='urlGitHub']");
    private By saveBtn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    public void setEmail(By email) {
        this.email = email;
    }

    public void setName(By name) {
        this.name = name;
    }

    public void setPhone(By phone) {
        this.phone = phone;
    }

    public void setCity(By city) {
        this.city = city;
    }

    public void setContry(By contry) {
        this.contry = contry;
    }

    public void setTwiter(By twiter) {
        this.twiter = twiter;
    }

    public void setGitHub(By gitHub) {
        this.gitHub = gitHub;
    }

    public void setSaveBtn(By saveBtn) {
        this.saveBtn = saveBtn;
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getPhone() {
        return getDriver().findElement(phone);
    }

    public WebElement getCity() {
        return getDriver().findElement(city);
    }

    public WebElement getContry() {
        return getDriver().findElement(contry);
    }

    public WebElement getTwiter() {
        return getDriver().findElement(twiter);
    }

    public WebElement getGitHub() {
        return getDriver().findElement(gitHub);
    }

    public WebElement getSaveBtn() {
        return getDriver().findElement(saveBtn);
    }

    public void editFakerProfile(String name, String phone, String city, String contry, String twiter, String gitHub) {

        name = faker.internet().domainName();
        phone = faker.phoneNumber().cellPhone();
        city = faker.address().cityName();
        contry = faker.address().country();
        twiter = faker.internet().url();
        gitHub = faker.internet().ipV4Address();


        getName().click();
        getName().sendKeys(name);

        getPhone().click();
        getPhone().sendKeys(phone);

        getCity().click();
        getCity().sendKeys(city);

        getContry().click();
        getContry().sendKeys(contry);

        getTwiter().click();
        getTwiter().sendKeys(twiter);

        getGitHub().click();
        getGitHub().sendKeys(gitHub);

        getSaveBtn().click();


    }
}
