import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailEmptyPasswordTest(){
        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test
    public void successfullLoginTest(){
        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    @Test
    public <LoginPage> void loginInvalidEmailPasswordTest(){
        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickSubmit();

        String url;
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test

    public void succesfullLoginPF(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("nemanja.sijacic@testpro.io").providePassword("Vojvodina.021").clickSubmitBnt();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
}

