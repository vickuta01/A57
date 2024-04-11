import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{
    @Test

    public void successfullLoginPF(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail("agnes.albertusiak@testpro.io").enterPassword("4Ameryka4aska!").clickSubmitBnt();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
}
