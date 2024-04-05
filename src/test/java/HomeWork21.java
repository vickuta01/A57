import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest{
    @Test
    public void renamePlayList(){
        String expectedResult = "Updated playlist \"Test111.\"";

        //GIVEN
        navigateToPage();
        provideEmail("elzat.nurmanbetova@testpro.io");

        providePassword("kochkor123-Q!");

        clickLoginBtn();

        //WHEN

        doubleClickPlayList();
        replaceName();
        newPlayListName();

        //THEN
        Assert.assertEquals(newPlayListName(), expectedResult);
    }

    public void doubleClickPlayList() {
       WebElement playListName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/93357']")));
        actions.doubleClick(playListName).perform();

    }
    public void replaceName(){
        WebElement playListField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name = 'name']")));
        playListField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playListField.sendKeys("Test111");
        playListField.sendKeys(Keys.ENTER);
    }
    public String newPlayListName (){
        WebElement newResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'success show']")));
        return newResult.getText();
    }

}
