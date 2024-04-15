package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public WebElement getUserAvatar;//I declared it by myself as I was prompted

    //constructor
    public HomePage(WebDriver givenDriver){super(givenDriver);}




    //Locators By page factory


    @FindBy(css ="span[data-testid='play-btn']" )
    private WebElement playerControlsBtnF;
    @FindBy(css = "i[data-testid='play-next-btn']")
    private WebElement playNextSongBtnF;
    @FindBy(css = "img[alt='Sound bars']")
    private WebElement soundBarF;
    @FindBy(css=".playlist:nth-child(3)")
    private WebElement firstPlaylistF;
    @FindBy(css ="[name='name']" )
    WebElement playlistNameFieldF;

    @FindBy(css = "div.success.show")
    WebElement renamePlaylistSuccessMsgF;
    @FindBy(css = "img.avatar")
    WebElement userAvatarIconF;

    /////////////////////
    /////////////////////By POM
    private By playerControlsBtnPOM=By.cssSelector("span[data-testid='play-btn']" );
    private By playNextSongBtnPOM= By.cssSelector("i[data-testid='play-next-btn']");
    private By soundBarPOM= By.cssSelector("img[alt='Sound bars']");

    By firstPlaylist =By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField =By.cssSelector("[name='name']");
    By renamePlaylistSuccessMsg= By.cssSelector("div.success.show");
    By userAvatarIcon = By.cssSelector("img.avatar");

    /////////////////////////



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
    public void playNextSongPOM(){
        findElement(playerControlsBtnPOM).click();
        findElement(playNextSongBtnPOM).click();
    }
    public void playNextSongF() {
        playerControlsBtnF.click();
        playNextSongBtnF.click();

    }
    public boolean isSoundBarVisiblePOM(){
        return findElement(soundBarPOM).isDisplayed();
        }

     public boolean isSoundBarVisible(){
        return soundBarF.isDisplayed();
     }





}
