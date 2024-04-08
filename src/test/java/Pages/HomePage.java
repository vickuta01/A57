package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
   //Web element
    By userAvatarIcon = By.cssSelector("img.avatar");

    //Helper methods
    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

}
