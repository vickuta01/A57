import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWork17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"karina playlist.\"";

        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginButton();
        Thread.sleep(2000);


        searchSong("fo");
        Thread.sleep(2000);
        clickViewAllButton();
        Thread.sleep(2000);
        selectFirstSong();
        Thread.sleep(2000);
        clickAddToButton();
        Thread.sleep(2000);
        choosePlaylist();
        Thread.sleep(2000);
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();

    }

    public void choosePlaylist() {
        WebElement playList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'karina playlist')]"));
        playList.click();
    }

    public void clickAddToButton() {
        WebElement AddToButton = driver.findElement(By.xpath("//button[@data-test='add-to-btn']"));
        AddToButton.click();
    }

    public void selectFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickViewAllButton() {
        WebElement viewAllButton = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }


}
