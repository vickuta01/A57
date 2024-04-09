package POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {

        super(givenDriver);
    }
    //LOCATORS
    By plusBtn = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    By createNewPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By playlistNameInput = By.cssSelector(".create input");
    By plNameInput = By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']");
    By checkHeader = By.cssSelector("#playlistWrapper h1");
    By delPlaylistBtn = By.cssSelector(".btn-delete-playlist");
    By toVerifyBanner = By.cssSelector(".success");
    private  By playlistLinks = By.cssSelector("#playlists a");
    public void createNewPlaylist(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(plNameInput);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        System.out.println(playlistName);
    }
    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }
    public void createNewPlaylistUsingPlusBtn(String playlistName) {
        WebElement plusButton = wait.until(ExpectedConditions.visibilityOfElementLocated(plusBtn));
        plusButton.click();

        WebElement presNewPlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(createNewPlaylist));
        presNewPlaylistBtn.click();

        WebElement inputPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(playlistNameInput));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }
    public void checkPlayListHeader(String playlist) {
        WebElement playlistHeader = waitUntilVisible(checkHeader);
        wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, playlist));
    }
    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = waitUntilClickable(delPlaylistBtn);
        deletePlaylistBtn.click();
    }
    public void verifyBanner() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toVerifyBanner));
    }
    public List<String> getAllPlaylistNames() {
        List<WebElement> playlistElements = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistLinks));
        // get playlist names from playlist elements
        List<String> playlistNames = new ArrayList<>();

        for (WebElement playlistElement : playlistElements){
            playlistNames.add(playlistElement.getText());
        }
        return playlistNames;
        System.out.println(playlistNames);
    }
}
