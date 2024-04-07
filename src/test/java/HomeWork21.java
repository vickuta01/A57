import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest{
    @Test
    public void renamePlayList(){
        String expectedResult = "Updated playlist \"Test1.\"";


        //GIVEN
        navigateToPage();
        provideEmail("elzat.nurmanbetova@testpro.io");

        providePassword("kochkor123-Q!");

        clickLoginBtn();

        //WHEN

        doubleClickPlayList();
        replacePlaylistName();
        newPlayListName();


        //THEN
        Assert.assertEquals(newPlayListName(), expectedResult);
    }

    public void replacePlaylistName() {
        WebElement replaceName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        replaceName.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.DELETE));
        replaceName.sendKeys("Test1");
        replaceName.sendKeys(Keys.ENTER);
    }

    public void doubleClickPlayList() {
       WebElement playListName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(2)")));
        actions.doubleClick(playListName).perform();
    }

    public String newPlayListName (){
        WebElement newResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'success show']")));
        return newResult.getText();
    }

}
