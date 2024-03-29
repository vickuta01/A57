import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class homeWork17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedSongAddedMessage = "Added 1 song into \"Test Pro Playlist.\"";


        //it appears your issue is the nosuchElementException in which selenium webdriver can't locate the input field for email
        //the issue is our test or automated browser is not navigating to koel webpage


        Thread.sleep(2000);
        provideEmail("elzat.nurmanbetova@testpro.io");
        Thread.sleep(2000);
        providePassword("kochkor123-Q!");
        clickLoginBtn();
        Thread.sleep(2000);
        searchSong("Dark");
        Thread.sleep(2000);
        clickViewAllBtn();
        Thread.sleep(2000);
        clickAddToBtn();
        Thread.sleep(2000);
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);
    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void clickLoginBtn(String songName) {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));

        submit.click();
    }

    public void provideEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.click();
    }
    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }
    //i don'
    public void searchSong(String s) {
        //locator for the seat rchField is missing a ' (in the search of type attribute)
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));

        searchField.clear();
        //missing input for sendKeys() use the String parameter 's'
        searchField.sendKeys(s);
    }
    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
        addToBtn.click();
    }

    //The error now is with clicking the view all button, I would suggest to try or check the locator used

    public void selectFirstSongResult() {
        WebElement firstSongInResult = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSongInResult.click();
    }


}







