import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{

        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        Assert.assertTrue(isSongPlaying());
    }

    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    //context click (right clink on  the mouse)
    public void contextClickFirstSong() throws InterruptedException{
WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSong).perform();
    }

    public void chooseAllSongsList() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
}
