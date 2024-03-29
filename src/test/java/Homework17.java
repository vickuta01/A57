import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedResult =  "Added 1 song into \"@@@$$$.\"";


        provideEmail("nina.vantsa@testpro.io");
        providePassword("Parasolka2006@");
        clickSubmitBtn();
        searchForSong("");
        clickViewAllBtn();
        clickFirstSong();
        clickAddTooBtn();
        choosePlayList();
        Thread.sleep(2000);
        getSuccessMsg();

        //Assertion
        Assert.assertEquals(getSuccessMsg(), expectedResult);


    }
    public String getSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlayList() {
        WebElement choosePlayList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), '@@@$$$')]"));
    }

    public void clickAddTooBtn() {
        WebElement clickAddTooBtn = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        clickAddTooBtn.click();
    }

    public void clickFirstSong() {
        WebElement clickFirstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//table[@class='items']"));
        clickFirstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement clickViewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        clickViewAllBtn.click();
    }

    public void searchForSong(String songName) {
      WebElement searchForSong = driver.findElement(By.xpath("//div[@id='searchForm']//input[@type='search']"));
      searchForSong.clear();
      searchForSong.sendKeys(songName);
    }



}
