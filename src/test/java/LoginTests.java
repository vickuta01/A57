import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        LoginPage loginPage = new LoginPage(driver);
        String url = "https://qa.koel.app/";
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        // Steps
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        loginPage.enterEmail("grigore.crepciuc@testpro.io");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();
        // Expected Result
        Assert.assertTrue(homepage.getAvatar());
        driver.quit();
    }

   @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        // Steps
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("invalid@class.com");
        loginPage.enterPassword("te$t$tudent");
        loginPage.clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
        // Post-condition
        driver.quit();
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        // Steps
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("demo@class.com");
        loginPage.clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/

        // Post-condition
        driver.quit();
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

