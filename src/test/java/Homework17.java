import org.apache.commons.lang3.exception.UncheckedInterruptedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() {



        navigateToPage();
        provideEmail("tassadit.talbi@testpro.io");
        providePassword("Password2026@");
        clickLoginBtn();
        Thread.sleep (2000);
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
        Thread.sleep (2000);
        searchSong (songName:"Pluto");
        Thread.sleep (2000);
        clickViewALLBtn();
        Thread.sleep (2000);
        selectFirstSongResult();
        Thread.sleep (2000);
        clickAddToBtn();
        Thread.sleep (2000);
        choosePlaylist();
        Thread.sleep (2000);
        Assert.assertEquals(getAddToPLaylistSuccessMsg(), expectedSongAddedMsg);




        }

    public void getAddToPLaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();


    }

    public void choosePlaylist () {
            WebElement choosePlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//Li[contains (text (),'Test Pro Playlist')]"));
            choosePlaylist.click();
        }

        public void clickAddToBtn () {
            WebElement AddToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-Btn']"));
            AddToBtn.click();

        }

        public void selectFirstSongResult () {
            WebElement FirstSongInResult = driver.findElement(By.xpath("//section[@id='SongResultsWrapper']//tr[@class='song-item'][1]"));
            FirstSongInResult.click();
        }

        public void clickViewALLBtn () {
            WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs"));
            viewAllBtn.click();
        }

        public void searchSong(String songName ) {
            WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search']"));
            searchField.clear();
            searchField.sendKeys(songName);
        }


    }







