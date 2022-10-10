import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRouthTests extends BaseTest {

    // Load the Home page and verify that the route/login appears in the url of the page

    @Test
    public void visitsToHomeUrl() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    // Load the Profile page and verify that the route/login appears in the url of the page

    @Test
    public void visitsToProfileUrl() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    // Load the admin/cities page and verify that the route/login appears in the url of the page

    @Test
    public void visitsToAdminCitiesUrl() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    // Load the admin/users page and verify that the route/login appears in the url of the page

    @Test
    public void visitsToAdminUsersUrl() {
        String expectedResult = "/login";
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}

