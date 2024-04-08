import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedDeletedPlaylistMsg = "Deleted playlist \"Test Pro Playlist.\"";

    provideEmail("aleksandr.parkizin@testpro.io");
    providePassword("Z0ffApQ6");
    clickBtn();
    Thread.sleep(2000);

    clickTestProPlaylist();
        Thread.sleep(2000);
    clickDeletePlaylist();
        Thread.sleep(2000);

    Assert.assertEquals(deletedPlaylistMsg(), expectedDeletedPlaylistMsg);

}

    public String deletedPlaylistMsg() {
        WebElement notification = driver.findElement(By.cssSelector("[class='success show']"));
        return notification.getText();
    }

    public void clickDeletePlaylist() {
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylistBtn.click();
    }

    public void clickTestProPlaylist() {
        WebElement testProPlaylistBtn = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[4]"));
        testProPlaylistBtn.click();
    }
}
