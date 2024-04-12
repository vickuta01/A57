package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    //WebElements
    @FindBy(css = "#mainFooter div[class='side player-controls']")
    private WebElement playerControlsBtn;

    @FindBy(css = "#mainFooter span[class='play']")
    private WebElement playNextSongBtn;

    @FindBy(css = "img[alt='Sound bars']")
    private  WebElement soundBar;

    public void playNextSong() {
        playerControlsBtn.click();
        playNextSongBtn.click();
    }

    public boolean isSoundBarVisible()
    {
       return soundBar.isDisplayed();
    }


}
