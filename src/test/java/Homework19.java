import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() {
//      Added ChromeOptions argument below to fix websocket error
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("grigore.crepciuc@testpro.io", "te$t$tudent");
        clickPlaylist();
        deleteSelectedPlaylist();
        waitCommand();
        clickOkBtn();
        showSuccessBanner();
    }


    public void clickPlaylist() {
        WebElement playlist = driver.findElement(By.cssSelector("[class='playlist playlist']"));
        playlist.click();
    }
    public void deleteSelectedPlaylist() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        js.executeScript("arguments[0].click();", deletePlaylistBtn);
    }
    public void waitCommand() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void clickOkBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        js.executeScript("arguments[0].click();", okBtn);
    }
    public void showSuccessBanner() {
        WebElement successBanner = driver.findElement(By.cssSelector("[class='success show']"));
        Assert.assertTrue(successBanner.isDisplayed());
    }

  /*  @Test
    public void deletePlaylist2() throws InterruptedException {
        //Login with valid credentials
        enterEmail("grigore.crepciuc@testpro.io");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        //Deletion of selected playlist
        clickPlaylistToDelate();
        clickDeletePlaylistBtn();
        WebElement deleteNotification = driver.findElement(By.cssSelector("[class='msg']"));
        Thread.sleep(2000);
        Assert.assertTrue(deleteNotification.isDisplayed());
        clickDeleteBtn();
        //Assertion Deleted playlist banner is displayed
        WebElement deleteBanner = driver.findElement(By.cssSelector("div[class='success show']"));
        Thread.sleep(2000);
        Assert.assertTrue(deleteBanner.isDisplayed());

    }

    private void clickDeleteBtn() {
        WebElement deleteOKBtn = driver.findElement(By.cssSelector("button[class='ok']"));
        deleteOKBtn.click();
    }

    private void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("[title='Delete this playlist']"));
        deletePlaylistBtn.click();
    }

    private void clickPlaylistToDelate() {
        WebElement playlistToDelete = driver.findElement(By.cssSelector("[href='#!/playlist/93352']"));
        playlistToDelete.click();
    }*/
}