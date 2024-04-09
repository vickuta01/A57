import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() {

        String playListName = "Test1";

        String expectedAlertMessage = "Deleted playlist " + "\"" + playListName + ".\"";

       /* //Log in using Email and Password
        provideEmail("sakthibala.sengottiyan@testpro.io");
        //Thread.sleep(1000);

        providePassword("Smg6reUh");
        //Thread.sleep(1000);

        clickLogIn();
        //Thread.sleep(2000);

        //Delete the playlist - "Test1"
        deleteFromPlaylist(playListName);
        //Thread.sleep(2000);

        //Verify the notification message
        Assert.assertEquals(getSuccessAlertMessage(), expectedAlertMessage); */

    }
}
