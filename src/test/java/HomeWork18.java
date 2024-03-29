import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {

        navigateToPage();
        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginButton();
        Thread.sleep(2000);

        clickPlayNextSongButton();
        Thread.sleep(2000);
        clickPlayButton();
        Thread.sleep(2000);
        Assert.assertTrue(isSongPlaying());
       
    }

    public boolean isSongPlaying() {
        WebElement pauseBtn = driver.findElement(By.xpath("//div[@class='side player-controls']//i[@class='fa fa-pause']"));
        return pauseBtn.isDisplayed();
    }

    public void clickPlayButton() {
        WebElement PlayBtn = driver.findElement(By.xpath("//div[@class='side player-controls']//i[@class='fa fa-play']"));
        PlayBtn.click();
    }

    public void clickPlayNextSongButton() {
        WebElement nextSongBtn = driver.findElement(By.xpath("//i[@class='next fa fa-step-forward control']"));
        nextSongBtn.click();
    }
}
