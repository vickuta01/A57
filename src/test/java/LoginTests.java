import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("sanjeela.chitrakar@testpro.io");
        loginPage.providePassword("te$t$tudent1");
        loginPage.submitBtn();

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }


}
