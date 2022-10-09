import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRouthTests extends BaseTest {


    @Test
    public void visitsToHome() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void visitsToProfile() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void visitsToAdminCities() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void visitsToAdminUsers() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}

