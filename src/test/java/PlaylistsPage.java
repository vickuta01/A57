import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaylistsPage extends BasePage{
    public PlaylistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
    By renamePlaylistField = By.cssSelector("[name='name']");
    By updatedPlaylistNotification = By.cssSelector(".success.show");
    By firstPlaylist = By.xpath("//section[@id='playlists']//li[@class='playlist playlist'][1]");
    //Methods
    public void doubleClickOnPlaylist() {
        doubleClick(firstPlaylist);
    }
    public void renamePlaylist(String playListName){
        findElement(renamePlaylistField).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElement(renamePlaylistField).sendKeys(playListName);
        findElement(renamePlaylistField).sendKeys(Keys.ENTER);
    }
    public String getUpdatedPlaylistNotification(){
        return findElement(updatedPlaylistNotification).getText();
    }

    }




