import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;

public class Homework23 extends BaseTest{
    @Test

    public void successfullLoginPF() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("nemanja.sijacic@testpro.io").providePassword("Vojvodina.021").clickSubmitBtn();
        Assert.assertTrue(homepage.getUserAvatarIcon().isDisplayed());
    }
}