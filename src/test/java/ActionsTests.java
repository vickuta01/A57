import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ActionsTests extends BaseTest {
    @Test
    public void playSongTest() {
        // hover over in clickPlayBtn
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        clickFooterPlayBtn();
        Assert.assertTrue(pauseBtnExists());


        // Comparing numbers of elements example
        List<WebElement> songs = driver.findElements(By.cssSelector("[data-test='song-card']"));

        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
        // Just an example: here we would add or delete an element but we didn't
        int songsNumberAfter = songs.size();
        System.out.println(songsNumberAfter);

        // Soft assert example
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(songsNumberBefore == songsNumberAfter,
                "=== Songs number before should be equal songs number after ===");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/#!/queue");
        System.out.println("Hello world");
        //softAssert.assertAll();
    }

    @Test
    public void renamePlaylist() {
        // double click
        LoginPage loginPage = new LoginPage(driver);
        String playlistName = "Sun And Wind";

        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        doubleClickChoosePlaylist();
        enterPlaylistName(playlistName);
        String newName = getPlaylistName();
        Assert.assertEquals(playlistName, newName, "=== PlaylistNames expected to be equals ===");
    }

    @Test
    public void playSongFromListTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        goToAllSongs();
        // right click on first song
        rightClickOnFirstSong();
        // click play button
        clickPlayBtn();
        // verify
        Assert.assertTrue(isEqualizerDisplayed());
    }

    private boolean isEqualizerDisplayed() {
        return driver.findElement(By.cssSelector("[data-testid='sound-bar-play']")).isDisplayed();
    }


    private void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector(".playback"));
        playBtn.click();
    }

    private void rightClickOnFirstSong() {
        WebElement firstSong = driver.findElement(By.cssSelector(".song-item"));
        Actions actions = new Actions(driver);
        actions.contextClick(firstSong).perform();
    }

    public void clickFooterPlayBtn() {
        Actions action = new Actions(driver);
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action
                .moveToElement(playBtn)
                .perform();
        playBtn.click();
    }

    public boolean pauseBtnExists() {
        return driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }


    private void goToAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".songs"))).click();
    }


    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    private String getPlaylistName() {
        WebElement playlistElement = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        String name = playlistElement.getText();
        return name;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void countSongsInPlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        playlist.click();
        List<WebElement> songs = driver.findElements(By.cssSelector("#playlistWrapper .song-item"));
        int number = songs.size();
        Assert.assertEquals(number, 3); // can fail, depends on current number. This is just an example

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void countSongsInsidePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        choosePlaylistByName("sap");
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }
    public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/93377']")))
                .click();
    }
    public void displayAllSongs(){
        List<WebElement>songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        //count and display songs names
        System.out.println("Number of songs in the playlist:"+ countSongs());
        for(WebElement e : songList){
            System.out.println(e.getText());
        }
    }
    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
}
