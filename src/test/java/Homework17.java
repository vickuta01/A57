import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";

        nevigateToPage("https://qa.koel.app/");
        provideEmail("nemanja.sijacic@testpro.io");
        providePassword("Vojvodina.021");
        clickLoginBtn();
        Duration millis;
        Thread.sleep(millis:2000);
        String songName;
        searchSong(songName: "Dark");
        Thread.sleep(millis:2000);
        clickViewAllBtn();
        Thread.sleep(millis:2000);
        selectFirstSongResult();
        Thread.sleep(millis:2000);
        clickAddToBtn();
        Thread.sleep(millis:2000);
        choosePlaylist();
        Thread.sleep(millis:2000);
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }

    private void nevigateToPage(String, "https://qa.koel.app/") {
    }

    private void provideEmail(String, "nemanja.sijacic@testpro.io") {
    }

    private void providePassword(String, "Vojvodina.021") {
    }

    private void clickLoginBtn() {
    }


    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
    public void choosePlaylist() {
        WebElement playlist = driver.findElement(By.xpath(xpathExpression:"//section[@id='songResultsWrapper']//li[contains(taxt(),'Test Pro Playlist')]"));
        playlist.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath(xpathExpression:"//section[@id'songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }
    public void selectFirstSongResult(){
        WebElement firstSongInResult = driver.findElement(By.xpath(xpathEpression:"//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSongInResult.click();
    }
    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath(xpathExpression:"//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }
    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.click();
        searchField.sendKeys(songName);
    }
}