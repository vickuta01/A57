import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PlaylistPage;

public class Homework23 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException {

        String playlistDeletedNotification = "Deleted playlist \"Sanjeelas Playlist1.\"";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("sanjeela.chitrakar@testpro.io")
                .providePassword("te$t$tudent1")
                .clickSubmitBtn();

        Thread.sleep(2000);   //I have use this Thread because without this my test got failed.

        HomePage homePage = new HomePage(driver);
        homePage.clickPlaylist();

        Thread.sleep(2000);


        PlaylistPage playlistPage = new PlaylistPage(driver);
        playlistPage.clickDeleteThisPlaylist();

        Thread.sleep(2000);

        Assert.assertEquals(playlistPage.getDeletePlaylistNotification(), playlistDeletedNotification);


    }
}

