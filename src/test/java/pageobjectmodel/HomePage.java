package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    private By playerControlsBtn = By.cssSelector("#mainFooter div[class='side player-controls']");

    private By playNextSongBtn = By.cssSelector("#mainFooter span[class='play']");

    private By soundBar = By.cssSelector("img[alt='Sound bars']");

    public void playNextSong()
    {
        findElement(playerControlsBtn).click();
        findElement(playNextSongBtn).click();
    }

    public boolean isSoundBarVisible()
    {
       return findElement(soundBar).isDisplayed();
    }


}
