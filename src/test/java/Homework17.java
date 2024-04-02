package Homework17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test
    public String addSongToPlaylist() throws Throwable {

        String expectedSongAddedMessage = "Added 1 song";
        Thread.sleep(2000);

        provideEmail("pearl.estrada@testpro.io");
        Thread.sleep(2000);
        providePassword("April969!!");
        Thread.sleep(2000);
        clickLogInBtn();
        Thread.sleep(2000);
        searchSong(songname:"Dark");
        Thread.sleep(4000);
        clickViewAllBtn();
        Thread.sleep(2000);
        selectFirstSongResult();
        Thread.sleep(2000);
        clickToAddBtn();
        Thread.sleep(2000);
        choosePlaylist(Fav Playlist);
        Thread.sleep(2000);
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
            WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Fav Playlist'])"));
        }
        public String getAddToPlaylistSuccessMsg() {
            WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
            return notification.getText();

            
        }
    }
}
