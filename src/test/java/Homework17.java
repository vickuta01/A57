
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws Throwable {

        String successAlertMessage = "Added 1 song";
        Thread.sleep(2000);

        provideEmail("pearl.estrada@testpro.io");
        Thread.sleep(2000);
        providePassword("April969!!");
        Thread.sleep(2000);
        clickLogInBtn();
        Thread.sleep(2000);
        searchSong(songName:"Dark");
        Thread.sleep(2000);
        clickViewAllBtn();
        Thread.sleep(2000);
        selectFirstSongResult();
        Thread.sleep(2000);
        clickToAddBtn();
        Thread.sleep(2000);
        addSongToPlaylist("Fav Playlist");
        Thread.sleep(2000);
        Assert.assertEquals(successAlertMsg(), sucessAlertMessage());


        public void clickLogInBtn() {
            WebElement logInBtn = driver.findElement(By.cssSelector("button[type='submit']"));
            logInBtn.click();
        }
        public void searchSong(String songName) {
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
        public void clickToAddBtn() {
            WebElement toAddBtn = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/header/div[3]/span/button[2]"));
            toAddBtn.click();
        }
        public void choosePlaylist() {
            WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Fav Playlist'])"));
        }
        public String getAddToPlaylistSuccessMsg() {
            WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
            return notification.getText();

            
        }
    }
}
