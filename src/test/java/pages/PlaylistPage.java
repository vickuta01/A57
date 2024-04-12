package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage extends BasePage{

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css="[class='del btn-delete-playlist']")
    WebElement deleteThisPlaylist;

    @FindBy(css="[class='ok']")
    WebElement clickOk;

    @FindBy(css="div.success.show")
    WebElement notification;

    public PlaylistPage clickDeleteThisPlaylist(){
        deleteThisPlaylist.click();
        clickOk.click();
        return this;
    }

    public String getDeletePlaylistNotification(){
        return notification.getText();
    }
}
