import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork23 extends BaseTest{
    @Test
    public void implementPageFactory(){
        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginpage.provideEmailLogin("elzat.nurmanbetova@testpro.io")
                .providePasswordLogin("kochkor123-Q!")
                .clickSubmitButton();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}
