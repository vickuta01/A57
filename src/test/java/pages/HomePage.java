package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
    By selectedPlayList = By.xpath("//li[@class= 'playlist playlist']//a[contains(text(), 'My Play List')]");
    By selectedPLField = By.cssSelector("[name = 'name']");
    By renamedPlayList = By.xpath("//div[@class= 'success show']");

    public void doubleClickSelectedPL(){
        doubleClick(selectedPlayList);
    }
    public void cleanAndEnterNewNave(String newPlayListName){
        findElement(selectedPLField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.DELETE));
        findElement(selectedPLField).sendKeys(newPlayListName);
        findElement(selectedPLField).sendKeys(Keys.ENTER);
    }
    public String getRenamedNewPlayList(){
        return findElement(renamedPlayList).getText();
    }

}
