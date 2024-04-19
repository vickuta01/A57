import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.HomePage;
import pageobjectmodel.LoginPage;

public class Homework24 extends BaseTest{

    @Test
    public void playSong() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //Login using Email and Password
        loginPage.login();

        //Click Play Next Song
        homePage.playNextSong();

        //Validate that the song is playing by checking the sound bar
        Assert.assertTrue(homePage.isSoundBarVisible());

    }
}
