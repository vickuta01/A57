import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist(){

        String deletedPlaylistMessage = "Deleted playlist";

        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        clickAnyPlaylist();
        clickDeletePlaylistBtn();


        Assert.assertTrue(getNotificationText().contains(deletedPlaylistMessage));


    }

}
