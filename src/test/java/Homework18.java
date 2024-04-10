import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        //GIVEN
        provideEmail("elliott.nance@testpro.io");
        providePassword("HondaAccord2024$");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

    ///WHEN
    public void clickPlay() {
        WebElement clickPlayNextSongBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        WebElement clickPlayBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        clickPlayNextSongBtn.click();
        clickPlayBtn.click();
    }


    //THEN
    public boolean isSongPlaying() {
        WebElement soundBar = driver.findElement(By.cssSelector("div[data-test='soundbars']"));
        return soundBar.isDisplayed();
    }
}
