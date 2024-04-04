import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String text = "Dark Days";
        String playlistName = generateRandomPlaylistName();
        // login
        login("demo@class.com", "te$t$tudent");
        // search for song
        findInput(text);
        // click results view all button
        clickViewAllBtn();
        // click first song
        firstSongInResults();
        Thread.sleep(2000);
        // click Add To
        clickAddToBtn();
        Thread.sleep(2000);
        // create new playlist
        createNewPlaylist(playlistName);
        // assertions - success banner and song name in playlist
        Assert.assertTrue(isBannerDisplayed());
        Assert.assertEquals(text, getSongName());

    }
    public String getSongName() {
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        return songText;
    }
    public boolean isBannerDisplayed(){
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        return successBanner.isDisplayed();

    }

    private void createNewPlaylist(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        System.out.println(playlistName);
    }

    private void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }

    private void firstSongInResults() {
        List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
        songsInResults.get(0).click();
    }

    private void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    private void findInput(String text) {
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }
}
/*import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";
        //Login
        openUrl();
        login("demo@class.com","te$t$tudent");
        //provideEmail("demo@class.com");
        //providePassword("te$t$tudent");
        //clickLoginBtn();
        Thread.sleep(2000);
        searchSong("Dark Days");
        Thread.sleep(2000);
        clickViewAllBtn();
        Thread.sleep(2000);
        selectFirstSongResult();
        Thread.sleep(4000);
        clickAddToBtn();
        Thread.sleep(2000);
        choosePlaylist();

        //Assertion
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlaylist() {
        WebElement playlist = driver.findElement
                (By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Pro Playlist')]"));
        playlist.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void selectFirstSongResult() {
        WebElement firstSongInResult = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSongInResult.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }

}*/