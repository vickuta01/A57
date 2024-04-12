
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
    @Test
    public void loginValidTest(){
        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginpage.provideEmail("elzat.nurmanbetova@testpro.io");
        loginpage.providePassword("kochkor123-Q!");
        loginpage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());


        }
}
