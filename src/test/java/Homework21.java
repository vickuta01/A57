import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    @Test
    public void renamePlaylist(){

        String expectedResult = "Updated playlist \"Success2.\"";

        provideEmail("nina.vantsa@testpro.io");
        providePassword("Parasolka2006@");
        clickSubmitBtn();
        doubleClickPlayList();
        enterNewPlaylistName();
        Assert.assertEquals(getNewPlayListName(), expectedResult);
    }

    public String getNewPlayListName() {
        WebElement successResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'success show']")));
        return successResult.getText();
    }

    public void enterNewPlaylistName() {
        WebElement playListField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name = 'name']")));
        playListField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.DELETE));
        playListField.sendKeys("Success2");
        playListField.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlayList() {;
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class= 'playlist playlist']//a[contains(text(), 'My Play List')]")));
        actions.doubleClick(playListElement).perform();
    }
}
