import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {


    @Test
    public void deletePlaylist() throws InterruptedException{

        String playlistDeletedNotification = "Deleted playlist \"Sanjeelas Playlist1.\"";

        navigateToLoginPage();
        provideEmail("sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
        clickPlaylist();


        clickDeleteThisPlaylist();


        Assert.assertEquals(getDeletePlaylistNotification(), playlistDeletedNotification);


    }

    public void clickPlaylist(){
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[contains(text(),'Sanjeelas Playlist1')]")));
        playlist.click();

    }

    public void clickDeleteThisPlaylist() throws InterruptedException{
        WebElement deleteThisPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        deleteThisPlaylist.click();

        Thread.sleep(2000);

        WebElement clickOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='ok']")));
        clickOk.click();
    }

    public String getDeletePlaylistNotification(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}

