import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("","");
        Assert.assertTrue(loginPage.isSubmitLoginBtnDisplayed());
        //Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        // Steps
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        loginPage.login("grigore.crepciuc@testpro.io","te$t$tudent");
        // Expected Result
        Assert.assertTrue(homepage.getAvatar());
    }

   @Test
    public void loginInvalidEmailValidPassword() {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        // Steps
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid@class.com","te$t$tudent");
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        // Steps
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("grigore.crepciuc@testpro.io","");
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }
    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        //steps
        //navigateToPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("Just Testing console");
    }

}

