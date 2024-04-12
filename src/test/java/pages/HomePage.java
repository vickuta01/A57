package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePages{
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    //webElements
    By userAvatarIcon = By.cssSelector("img.avatar");

    //helper methods
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
}
