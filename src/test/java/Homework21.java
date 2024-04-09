import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist()
    {
        String playListName = "Test1";
        String newPlayListName = "Test2";

        String expectedAlertMessage = "Updated playlist " + "\"" + newPlayListName + ".\"";

        /*//Log in using Email and Password
        provideEmail("sakthibala.sengottiyan@testpro.io");
        providePassword("Smg6reUh");
        clickLogIn();

        //Rename the PlayList
        changePlayListName(playListName,newPlayListName);

        //Verify the notification message
        Assert.assertEquals(getSuccessAlertMessage(), expectedAlertMessage);*/


    }
}
