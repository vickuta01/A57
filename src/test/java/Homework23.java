import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest {
    @Test
    public void loginValidEmailPassword() {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        // Steps
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        loginPage.enterEmail("grigore.crepciuc@testpro.io").enterPassword("te$t$tudent").clickLoginBtn();
        //loginPage.enterPassword("te$t$tudent");
        //loginPage.clickLoginBtn();
        //loginPage.login("grigore.crepciuc@testpro.io","te$t$tudent");
        // Expected Result
        Assert.assertTrue(homepage.getAvatar());
    }
}
