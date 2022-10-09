import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRouthTests extends BaseTest {


    @Test
    public void visitsToHomeUrl() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void visitsToProfileUrl() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void visitsToAdminCitiesUrl() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void visitsToAdminUsersUrl() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}

