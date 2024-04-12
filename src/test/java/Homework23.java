import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjectmodel.HomePage;
import pageobjectmodel.LoginPage;

public class Homework23 extends BaseTest{

    @Test
    public void playSong() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Implementation of fluent interface
        //Login using Email and Password
        loginPage.provideEmail("sakthibala.sengottiyan@testpro.io")
                 .providePassword("Smg6reUh")
                 .clickLogIn();

        //Click Play Next Song
        homePage.playNextSong();

        //Validate that the song is playing by checking the sound bar
        Assert.assertTrue(homePage.isSoundBarVisible());

    }
}
