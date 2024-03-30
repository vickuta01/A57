import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() {

        String newSongAddedNotification = "Added 1 song into";
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        searchSong("Dark Days");
        clickViewAllBtn();
        clickTheFirstSong();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));

    }


}
