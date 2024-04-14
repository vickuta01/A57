package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePages{
    public HomePage(WebDriver givenDriver){

        super(givenDriver);
    }
    //webElements
   // By userAvatarIcon = By.cssSelector("img.avatar");
    @FindBy(xpath = "//a[@href='#!/playlist/93564']")
    WebElement playlistTest;
    @FindBy(xpath = "//button[@class='del btn-delete-playlist']")
    WebElement deleteSong;
    @FindBy(xpath = "//div[@class='success show']")
    WebElement getDeleteMessage;

    //Method using Page Factory
    public HomePage playListName(String name){
        playlistTest.click();
        return this;
    }
    public HomePage deleteExistingPlaylist(){
        deleteSong.click();
        return this;
    }
    public String getDeletedMessage(){
       return getDeleteMessage.getText();
    }
}


