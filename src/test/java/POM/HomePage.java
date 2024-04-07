package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    By playerControlsBtn = By.cssSelector("#mainFooter div[class='side player-controls']");

    By playNextSongBtn = By.cssSelector("#mainFooter span[class='play']");

    By soundBar = By.cssSelector("img[alt='Sound bars']");

    By avatarIcon = By.cssSelector("img[class='avatar']");
    public void playNextSong()
    {
        findElement(playerControlsBtn).click();
        findElement(playNextSongBtn).click();
    }

    public boolean isSoundBarVisible()
    {
        return findElement(soundBar).isDisplayed();
    }
    public WebElement getUserAvatarIcon(){
        return findElement(avatarIcon);
    }


}