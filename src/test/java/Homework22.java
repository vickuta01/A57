import POM.BaseTest;
import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    //Prerequisite -create Playlist

    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Homework22";
        String updatedPlaylistMsg="Updated playlist \"Homework22.\"";

        LoginPage loginPage= new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        homePage.doubleClickFirstPlaylist();

        homePage.enterNewPlaylistName(newPlaylistName);


        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);
    }
}

