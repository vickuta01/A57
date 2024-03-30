import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() {
        String expectedMsg = "Deleted playlist \"Test.\"";
        //Steps:
        //Navigate and Login
        provideEmail("yurii.lyndiuk@testpro.io");
        providePassword("jjbuQe8D");
        clickLoginBtn();
        //Click the playlist
        clickThePlaylist();
        //Click delete button
        clickDeleteBtn();
        //Assertion
        Assert.assertEquals(deletedPlaylistMsg(),expectedMsg);
    }

    public void clickDeleteBtn() {
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylist.click();
    }

    public void clickThePlaylist() {
        WebElement playList = driver.findElement(By.xpath("//section[@id='playlists']//li[@class='playlist playlist'][2]"));
        playList.click();
    }

    public String deletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector(".success.show"));
        return notificationMsg.getText();

    }
}
