package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.text.Element;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(xpath = "//li[@class= 'playlist playlist']//a[contains(text(), 'My Play List')]")
    WebElement selectedListLocator;
    @FindBy(css = "[name = 'name']")
    WebElement selectedNewNameLocator;
    @FindBy(xpath = "//div[@class= 'success show']")
    WebElement renamedPLocator;

    public void doubleClickLocator(){
    actions.doubleClick(selectedListLocator).perform();
    }
    public void cleanEnterListLocator(String newPlayListName){
        selectedNewNameLocator.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.DELETE));
        selectedNewNameLocator.sendKeys(newPlayListName);
        selectedNewNameLocator.sendKeys(Keys.ENTER);
    }
    public String getRenamedListLocator(){
        return renamedPLocator.getText();
    }
}
