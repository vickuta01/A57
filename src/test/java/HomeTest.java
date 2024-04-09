import page.AllSongsPage;
import page.AllSongsPage;
import page.HomePage;
import page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class HomeTest extends BaseTest{
    String newPlaylistName="Sample Edited Playlist";

    //Test#1 Contextual Click
    @Test
    public void playSong() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        //Login
        loginPage.provideEmailLogin("Sanjeela.chitrakar@testpro.io");
        loginPage.providePasswordLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();

        HomePage homePage = new HomePage(driver);
        homePage.chooseAllSongsList();

        AllSongsPage songsPage = new AllSongsPage(driver);
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();

        //Assertion
        Assert.assertTrue(songsPage.isPlaying());


    }
    //*************************************************************************************************************************

    //Test#2 Mouse Hover
    @Test
    public void hoverOverPlayButton()throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmailLogin("sanjeela.chitrakar@testpro.io");
        loginPage.providePasswordLogin("te$t$tudent1");
        loginPage. clickSubmitBtn();
        Thread.sleep(2000);

        HomePage homePage = new HomePage(driver);

        //Assertion
        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }


    //*************************************************************************************************************************




    /** //Helper Methods
    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public void contextClickFirstSong(){
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSong).perform();
    }
    public void choosePlayOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();

    }

    public boolean isPlaying(){
        WebElement soundbarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundbarVisualizer.isDisplayed();
    }**/

   //***********************************************************************************************************

   }

