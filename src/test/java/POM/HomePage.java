package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public WebElement getUserAvatar;//I declared it by myself as I was prompted

    //constructor
    public HomePage(WebDriver givenDriver){super(givenDriver);}

    //Locator
By firstPlaylist =By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField =By.cssSelector("[name='name']");
    By renamePlaylistSuccessMsg= By.cssSelector("div.success.show");
    By userAvatarIcon = By.cssSelector("img.avatar");

    //Method
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
    public void doubleClickFirstPlaylist(){
        doubleClick(firstPlaylist);
    }
    public void enterNewPlaylistName(String playlistName){
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        return findElement(renamePlaylistSuccessMsg).getText();
    }
}
