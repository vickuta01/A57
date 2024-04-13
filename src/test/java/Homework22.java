import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    @Test
    public void deletePlaylistTest() {
        //String deletedPlaylistMessage = "Deleted playlist";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());


        loginPage.login();
        homePage.clickFirstPlayist();
        homePage.clickDeleteBtn();

        Assert.assertTrue(homePage.successfullNotifMessage().isDisplayed());
    }
}