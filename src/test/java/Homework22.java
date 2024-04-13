import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String PlaylistName = "homework22";
        String expectedupdatedPlailistMsg = "Updated playlist \""+PlaylistName+".\"";

        LoginPage loginPage = new LoginPage(driver);
        PlaylistsPage playlistsPage = new PlaylistsPage(driver);

        loginPage.login();
        playlistsPage.doubleClickOnPlaylist();
        playlistsPage.renamePlaylist(PlaylistName);
        Assert.assertEquals(playlistsPage.getUpdatedPlaylistNotification(), expectedupdatedPlailistMsg);
    }
}
