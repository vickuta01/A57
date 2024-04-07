package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By doubleClickPlaylistLocator = By.cssSelector("li.playlist:nth-child(3)");
    private By enterNewPlaylistNameLocator = By.cssSelector("[name='name']");
    private By getRenamePlaylistSuccessMsgLocator = By.cssSelector("div.success.show");

    public void doubleClickPlaylist(){
        WebElement clickPlaylist = findElement(doubleClickPlaylistLocator);
        actions.doubleClick(clickPlaylist).perform();

    }

    public void enterNewPlaylistName(String newPlaylistName){
        WebElement playlistName = findElement(enterNewPlaylistNameLocator);
        playlistName.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistName.sendKeys(newPlaylistName);
        playlistName.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = findElement(getRenamePlaylistSuccessMsgLocator);
        return notification.getText();
    }



    }

