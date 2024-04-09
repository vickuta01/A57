import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void LoginValidEmailPasswordByPageFactory() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmailLogin("sanjeela.chitrakar@testpro.io")
                .providePasswordLogin("te$t$tudent1")
                .clickSubmitBtn();
        Thread.sleep(2000);


        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}
