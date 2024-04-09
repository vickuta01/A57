import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test
    public void deletePlaylist() {

        String playListName = "Test1";

        String expectedAlertMessage = "Deleted playlist " + "\"" + playListName + ".\"";

        /* //Log in using Email and Password
        provideEmail("sakthibala.sengottiyan@testpro.io");
        providePassword("Smg6reUh");
        clickLogIn();

        //Delete the playlist - "Test1"
        deleteFromPlaylist(playListName);

        //Verify the notification message
        Assert.assertEquals(getSuccessAlertMessage(), expectedAlertMessage);*/

    }
}
