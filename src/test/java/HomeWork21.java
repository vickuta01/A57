import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.awt.SystemColor.text;

public class HomeWork21 extends BaseTest {

    String newPlaylistName ="karina playlist new";
    @Test
    public void renamePlaylist() {
        String newPlaylistMsg = "Updated playlist \""+newPlaylistName+".\"";
        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginButton();

        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getNewPlaylistSuccMsg(),newPlaylistMsg);


    }

    public String getNewPlaylistSuccMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist']")));
        actions.doubleClick(playlist).perform();
    }
}
