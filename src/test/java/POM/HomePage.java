package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public WebElement getUserAvatar;//I declared it by myself as I was prompted

    //constructor
    public HomePage(WebDriver givenDriver){super(givenDriver);}
    //Locator

    By userAvatarIcon = By.cssSelector("img.avatar");

    //Method
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
}
