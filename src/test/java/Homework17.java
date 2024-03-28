import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import static java.lang.Thread.*;
import static org.checkerframework.checker.units.qual.Prefix.milli;


public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        String expectedSongAddedMessage = "Added 1 song into Fav Playlist";

        provideEmail("pearl.estrada@testpro.io");
        sleep(2000);
        providePassword("April969!!");
        sleep(2000);
        clickLogInBtn();
        sleep(2000);
        searchSong(songname:"DarkDays");
        sleep(4000);
        clickViewAllBtn();
        sleep(2000);
        selectFirstSongResult();
        sleep(2000);
        clickToAddBtn();
        sleep(2000);
        choosePlaylist(Fav Playlist);
        sleep(2000);
        Assert.assertEquals(getAddToPlaylistSuccessMsg, expectedSongAddedMessage);


        public void clickLogInBtn() {
            WebElement logInBtn = driver.findElement(By.cssSelector("button[@data-test type='submit']"));
            logInBtn.click();
        }
        public void searchSong(String songName){
            WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
            searchField.clear();
            searchField.sendKeys(songName);
        }
        public void clickViewAllBtn() {
            WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
            viewAllBtn.click();
        }
        public void selectFirstSongResult() {
            WebElement firstSongInResult = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
            firstSongInResult.click();
        }
        private void clickToAddBtn() {
            WebElement toAddBtn = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button[2]"));
            toAddBtn.click();
        }
         private void choosePlaylist() {
            WebElement playlist =driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Fav Playlist'])"));
        }
        public String getAddToPlaylistSuccessMsg() {
            WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
            return notification.getText();
        }
    }
}
