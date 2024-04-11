import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
      String newPlaylistName = "homework21";
    @Test
    public void renamePlaylist() {
        String expectedupdatedPlailistMsg = "Updated playlist \""+newPlaylistName+".\"";
        //Steps
        //Login
        provideEmail("yurii.lyndiuk@testpro.io");
        providePassword("jjbuQe8D");
        clickLoginBtn();
        //Double-click on the Playlist
        doubleClickPlaylist();
        //Rename Playlist
        editPlayList();
        //Assertion
        Assert.assertEquals(getUpdatedPlaylistMsg(), expectedupdatedPlailistMsg);

    }

    public void editPlayList() {
        WebElement edit =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        edit.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        edit.sendKeys(newPlaylistName);
        edit.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[@class='playlist playlist'][1]")));
        actions.doubleClick(playList).perform();


    }
    public String getUpdatedPlaylistMsg() {
        WebElement updatedPlaylistNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return updatedPlaylistNotification.getText();
    }

}
