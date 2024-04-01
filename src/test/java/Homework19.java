import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist(){
        String expectedResult = "Deleted playlist \"12.\"";

     provideEmail("nina.vantsa@testpro.io");
     providePassword("Parasolka2006@");
     clickSubmitBtn();
     clickPlayList();
     clickDeleteBtn();
     successResult();
     String actualResult = successResult();
     Assert.assertEquals(actualResult, expectedResult);
    }

    public String successResult() {
        WebElement successResultElement = driver.findElement(By.xpath("//div[@class= 'success show']"));
        return successResultElement.getText();
    }

    public void clickDeleteBtn() {
        WebElement clickDeleteBtn = driver.findElement(By.xpath("//button[@title= 'Delete this playlist']"));
        clickDeleteBtn.click();

    }

    public void clickPlayList() {
        WebElement clickPlayList = driver.findElement(By.xpath("//li[@class= 'playlist playlist']//a[contains(text(), '12')]"));
        clickPlayList.click();
    }
}
