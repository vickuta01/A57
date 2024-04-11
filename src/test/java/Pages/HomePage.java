package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //WebElements

    private By avatarIcon = By.cssSelector("img[class='avatar']");
    private By notificationMessage = By.cssSelector("div.success.show");
    private By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private By deleteBtn = By.cssSelector("button.del.btn-delete-playlist");
    public WebElement getUserAvatarIcon(){
        return findElement(avatarIcon);
    }

    public WebElement successfullNotifMessage(){return findElement(notificationMessage);}

    public void clickFirstPlayist(){findElement(firstPlaylist).click();}
    public void clickDeleteBtn(){findElement(deleteBtn).click();}
}
