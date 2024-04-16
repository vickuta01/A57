import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlaylistsPage;

public class Homework22 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String PlaylistName = "homework22";
        String expectedUpdatedPlaylistMsg = "Updated playlist \""+PlaylistName+".\"";

        LoginPage loginPage = new LoginPage(driver);
        PlaylistsPage playlistsPage = new PlaylistsPage(driver);

        loginPage.login();
        playlistsPage.doubleClickOnPlaylist();
        playlistsPage.renamePlaylist(PlaylistName);
        Assert.assertEquals(playlistsPage.getUpdatedPlaylistNotification(), expectedUpdatedPlaylistMsg);
    }
}
