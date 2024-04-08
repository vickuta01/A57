import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
@Test
    public void loginValidEmailAndValidPassword () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("karina.usmanova01@testpro.io");
        loginPage.providePassword("YrEdlRVe");
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void clickRegistrationForgotPasswordText () {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        loginPage.clickRegistrationLink();

        Assert.assertTrue(registrationPage.getSubmitBtn().isDisplayed());
    }
}
