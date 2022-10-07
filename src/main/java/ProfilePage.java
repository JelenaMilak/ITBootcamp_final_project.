import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    Faker faker = new Faker();
    private By cityManu = By.xpath("//*[@id='list-item-162-6']/div");
    private By email = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[1]");
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

    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    public WebElement getCityManu() {
        return getDriver().findElement(cityManu);
    }

    public void setCityManu(By cityManu) {
        this.cityManu = cityManu;
    }

    public WebElement getArrow() {
        return getDriver().findElement(arrow);
    }

    public void setArrow(By arrow) {
        this.arrow = arrow;
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

    public void editFakerProfile(String name, String phone, String city, String contry, String twiter, String gitHub, String arrow) throws InterruptedException {

        name = faker.internet().domainName();
        phone = faker.phoneNumber().cellPhone();

        city = faker.address().city();

        contry = faker.address().country();
        twiter = faker.internet().url();
        gitHub = faker.internet().url();



        getName().click();
        getName().sendKeys(name);
        Thread.sleep(5000);


        getPhone().click();
        getPhone().sendKeys(phone);
        Thread.sleep(5000);

        getArrow().click();
        //getCity().click();
        getCityManu().click();
        //getCity().sendKeys();
        Thread.sleep(5000);


        getContry().click();
        getContry().sendKeys(contry);
        Thread.sleep(5000);

        getTwiter().click();
        getTwiter().sendKeys("https://"+ twiter);
        Thread.sleep(5000);

        getGitHub().click();
        getGitHub().sendKeys("https://"+gitHub);
        Thread.sleep(5000);

        getSaveBtn().click();


    }
}
