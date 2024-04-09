import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Homework22 extends BaseTest{

    @Test
    public void renamePlaylist() throws InterruptedException {
        String newPlaylistName = "Test Pro Edited Playlist";
        String updatedPlaylistMsg = "Updated playlist \"Test Pro Edited Playlist.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Thread.sleep(1000);
        homePage.doubleClickFirstPlaylist();
        Thread.sleep(1000);
        homePage.enterNewPlaylistName(newPlaylistName);

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

}
