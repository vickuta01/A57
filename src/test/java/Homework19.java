import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        String deletedPlaylistMsg = "Deleted playlist \"karina playlist.\"";
        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginButton();
        Thread.sleep(2000);

        clickOnPlaylist();
        Thread.sleep(2000);
        clickDeleteThisPlaylist();
        Thread.sleep(2000);
        Assert.assertEquals(getDeletedPlaylistSuccessMsg(), deletedPlaylistMsg);
    }

    public String getDeletedPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.xpath("//div[@class='success show']"));
        return notification.getText();
    }


    public void clickDeleteThisPlaylist() {
        WebElement deleteThisPlaylistBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deleteThisPlaylistBtn.click();
    }

    public void clickOnPlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//a[@href='#!/playlist/93028']"));
        playlist.click();

    }
}
