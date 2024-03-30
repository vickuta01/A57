import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() {

        boolean soundBarDisplayed = true;

        //Log in using Email and Password
        provideEmail("sakthibala.sengottiyan@testpro.io");
        //Thread.sleep(1000);

        providePassword("Smg6reUh");
        //Thread.sleep(1000);

        clickLogIn();
        //Thread.sleep(2000);

        //Click Play Next Song
        playNextSong();
        //Thread.sleep(2000);

        //Validate that the song is playing by checking the sound bar
        Assert.assertEquals(isSoundBarVisible(),soundBarDisplayed);
        //Thread.sleep(1000);

    }
}
