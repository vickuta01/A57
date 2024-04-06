import Page.HomePage;
import Page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest{

    @Test
    public void renamePlaylist(){
        String updatedPlaylistMsg ="Updated playlist \"Sanjeela Edited Playlist.\"";

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("sanjeela.chitrakar@testpro.io");
        loginPage.providePassword("te$t$tudent1");
        loginPage.clickSubmitBth();

        HomePage homePage = new HomePage(driver);

        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName("Sanjeela Edited Playlist");

        String notification = homePage.getRenamePlaylistSuccessMsg();
        Assert.assertEquals(notification, updatedPlaylistMsg);

    }

}
