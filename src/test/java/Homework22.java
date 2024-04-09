
import pageobjectmodel.HomePage;
import pageobjectmodel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{


    @Test
    public void playSong() {

        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        //Login using Email and Password
        loginpage.login();

        //Click Play Next Song
        homepage.playNextSong();

        //Validate that the song is playing by checking the sound bar
        Assert.assertTrue(homepage.isSoundBarVisible());

    }


}
