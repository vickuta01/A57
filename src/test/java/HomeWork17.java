
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork17 extends BaseTest{
    @Test
    public void addSongToPlaylist()  throws InterruptedException {

        String playListName = "Test1";

        String expectedAlertMessage = "Added 1 song into " + "\"" + playListName + ".\"";

        //Thread.sleep(1000);

        //Enter Email
        provideEmail("sakthibala.sengottiyan@testpro.io");
        //Thread.sleep(1000);

        //Enter Password
        providePassword("Smg6reUh");
        //Thread.sleep(1000);

        //Click Log In
        clickLogIn();
        //Thread.sleep(2000);

        //Search for a song
        searchSong("Episode");
        //Thread.sleep(2000);

        //Click View All Button
        clickViewAll();
        //Thread.sleep(2000);

        //Click the first song in the search results
        clickFirstSong();
        //Thread.sleep(2000);

        //Click Add To button
        clickAddTo();
        //Thread.sleep(2000);

        //Choose the playlist to add to
        addToPlayList(playListName);
        //Thread.sleep(2000);

        //Verify the notification message
        Assert.assertEquals(getSuccessAlertMessage(), expectedAlertMessage);


    }

}