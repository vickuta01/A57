import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

  @Test
  public void addSongToPlaylist() throws InterruptedException {
          //navigate to page
          //login with credentials
      provideEmail("kseniya.potsina@testpro.io");
      providePassword("testproA57*");
      clickLoginBtn();
      Thread.sleep(2000);
          //search for song
      searchSong("beautiful");
      Thread.sleep(2000);
          //click view all btn
      clickViewAllBtn();
          //click first song in the result list
      clickFirstSong();
          //click "add to " btn
      addToPlaylist();
      Thread.sleep(2000);
          //verify that notification message appears
     String expectedSongAddedMsg = "Added 1 song into \"homework17.\"";
      Assert.assertEquals(getAddToPlaylistSuccessMsg(),expectedSongAddedMsg);

      driver.quit();



  }

    public void searchSong(String songName) {
        WebElement searchField=driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public void clickViewAllBtn(){
      WebElement viewAllBtn =driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
      viewAllBtn.click();
    }

    public void clickFirstSong (){
      WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
      firstSong.click();
    }
    public void addToPlaylist () {
      WebElement addToBtn =driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
      addToBtn.click();
      WebElement choosePlaylist=driver.findElement(By.xpath("//section[@id='songResultsWrapper']/header/div/div/section/ul/li[6]"));
      choosePlaylist.click();
    }
    public String getAddToPlaylistSuccessMsg (){
      WebElement notification = driver.findElement(By.cssSelector("div[class='success show']"));
      return notification.getText();
    }
}
