import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    Faker faker = new Faker();
    private By cityManu = By.xpath("//*[@id='list-item-162-6']/div");
    private By email = By.xpath("//*[@id='app']/div[4]/div/div/div[3]/button[2]");
    private By name = By.xpath("//*[@id='name']");
    private By phone = By.xpath("//*[@id='phone']");
    private By city = By.xpath("//*[@id='city']");
    private By contry = By.xpath("//*[@id='country']");
    private By twiter = By.xpath("//*[@id='urlTwitter']");
    private By gitHub = By.xpath("//*[@id='urlGitHub']");
    private By saveBtn = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private By arrow = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[2]/div/i");

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public WebElement getCityManu() {
        return getDriver().findElement(cityManu);
    }

    public WebElement getArrow() {
        return getDriver().findElement(arrow);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getPhone() {
        return getDriver().findElement(phone);
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

    public void editFakerProfile(String name, String phone, String city, String contry, String twiter, String gitHub, String arrow) throws InterruptedException {

        name = faker.internet().domainName();
        phone = faker.phoneNumber().cellPhone();
        contry = faker.address().country();
        twiter = faker.internet().url();
        gitHub = faker.internet().url();

        getName().click();
        getName().sendKeys(name);

        getPhone().click();
        getPhone().sendKeys(phone);

        getArrow().click();
        getCityManu().click();

        getContry().click();
        getContry().sendKeys(contry);

        getTwiter().click();
        getTwiter().sendKeys("https://" + twiter);

        getGitHub().click();
        getGitHub().sendKeys("https://" + gitHub);

        getSaveBtn().click();


    }
}
