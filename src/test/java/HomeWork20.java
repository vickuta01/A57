import com.fasterxml.jackson.databind.JsonSerializable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest {
    @Test
    public void deletePlaylist() {
        String deletedPlaylistMsg = "Deleted playlist \"karina playlist.\"";
        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginButton();

        clickOnPlaylist();
        clickDeleteThisPlaylist();
        Assert.assertEquals(getDeletedPlaylistSuccessMsg(), deletedPlaylistMsg);
    }

    public String getDeletedPlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"success show\"]")));
        return notification.getText();

    }

    public void clickDeleteThisPlaylist() {
        WebElement deleteThisPlaylistBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deleteThisPlaylistBtn.click();
    }

    public void clickOnPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='playlist playlist']")));
        playlist.click();

    }

}
