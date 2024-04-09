package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //Locator

    //Helper
    public WebElement getUserAvatar(){
        return findElement(By.cssSelector("img.avatar"));
    }

    public WebElement hoverPlay(){
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }





   //**************************************************************************************************************
    public void doubleClickPlaylist(){
        WebElement clickPlaylist = findElement(By.cssSelector("li.playlist:nth-child(3)"));
        actions.doubleClick(clickPlaylist).perform();

    }

    public void enterNewPlaylistName(String newPlaylistName){
        WebElement playlistName = findElement(By.cssSelector("[name='name']"));
        playlistName.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistName.sendKeys(newPlaylistName);
        playlistName.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }



    }

