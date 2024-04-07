
import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{


    @Test
    public void playSong() {

        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginpage.login();

        homepage.playNextSong();

        Assert.assertTrue(homepage.isSoundBarVisible());

    }


}