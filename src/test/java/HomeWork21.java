import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest{
    @Test
    public void renamePlayList()throws InterruptedException{
        String expectedResult = "Updated playlist \"Test111.\"";
        //GIVEN
        provideEmail("elzat.nurmanbetova@testpro.io");
        Thread.sleep(2000);
        providePassword("kochkor123-Q!");
        Thread.sleep(2000);
        clickLoginBtn();
        Thread.sleep(2000);
        //WHEN
        doubleClickPlayList();
        Thread.sleep(2000);
        replaceName();
        Thread.sleep(2000);
        //THEN
        Assert.assertEquals(newPlayListName(), expectedResult);
    }

    public void doubleClickPlayList() {
       WebElement playListName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist'")));
        actions.doubleClick(playListName).perform();

    }
    public void replaceName(){
        WebElement playListField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name = 'name']")));
        playListField.clear();
        playListField.sendKeys("Test111");
        playListField.sendKeys(Keys.ENTER);
    }
    public String newPlayListName (){
        WebElement newResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'success show']")));
        return newResult.getText();
    }

}
