package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locator

    //Helper
    public WebElement getUserAvatar(){
        return findElement(By.cssSelector("img.avatar"));
    }
}
