import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Fav Playlist,\"";
        provideEmail("pearl.estrada@testpro.io");
        Thread.sleep(2000);
        providePassword("April969!!");
        Thread.sleep(2000);
        clickLogInBtn();
        Thread.sleep(2000);
        searchSong("Dark");
        clickViewAllBtn();
        Thread.sleep(2000);
        selectFirstSongResult();
        Thread.sleep(2000);
        clickAddToBtn();
        Thread.sleep(2000);
        choosePlaylist();
        Thread.sleep(2000);
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

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

    private void clickAddToBtn() {
        WebElement AddToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        AddToBtn.click();
    }

    private void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Fav Playlist'])"));
        playlist.click();
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }

}