import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String playlist = generateRandomPlaylistName();
        login("grigore.crepciuc@testpro.io", "te$t$tudent");
        // CREATE PLAYLIST
        // click Plus btn
        clickOnPlusBtn();
        // click Create new playlist
        clickNewPlaylistBtn();
        // Add playlist name
        sentNewPlaylistName(playlist);
        // check playlist name in header
        checkPlayListHeader(playlist);
        // delete playlist
        clickDeletePlaylistBtn();
        // verify banner
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
        // refresh page
        driver.navigate().refresh();
        // get all playlist elements
        List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists a"));
        // get playlist names from playlist elements
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
        }
        System.out.println(playlistNames);
        // assert playlist was deleted
        Assert.assertFalse(playlistNames.contains(playlist));
    }

    private void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = waitUntilClickable(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistBtn.click();
    }

    private void checkPlayListHeader(String playlist) {
        WebElement playlistHeader = waitUntilVisible(By.cssSelector("#playlistWrapper h1"));
        wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, playlist));
    }

    private void sentNewPlaylistName(String playlist) {
        WebElement inputPlaylistName = waitUntilClickable(By.cssSelector(".create input"));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys(playlist);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }

    private void clickNewPlaylistBtn() {
        WebElement presNewPlaylistBtn = waitUntilVisible(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        presNewPlaylistBtn.click();
    }

    private void clickOnPlusBtn() {
        WebElement plusBtn = waitUntilVisible(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        plusBtn.click();
    }
}