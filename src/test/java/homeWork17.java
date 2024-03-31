import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeWork17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws Throwable {
        String successAlertMessage = "1 song is added";
        Thread.sleep(2000);
        //Login
        provideEmail("elzat.nurmanbetova@testpro.io");
        Thread.sleep(2000);

        providePassword("kochkor123-Q!");
        Thread.sleep(2000);

        clickLoginBtn();
        Thread.sleep(2000);

        searchSong("Dark");
        Thread.sleep(2000);

        clickViewAll();
        Thread.sleep(2000);

        clickFirstSong();
        Thread.sleep(2000);

        clickAddTo();
        Thread.sleep(2000);

        addToPlayList("Testpro Playlist");
        Thread.sleep(2000);
        //Assertion
        Assert.assertEquals(successAlertMessage(),successAlertMessage() );
    }
}





