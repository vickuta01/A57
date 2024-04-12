import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

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
    private String successResult() {
    WebElement successRE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'success show']")));
        //WebElement successResultElement = driver.findElement(By.xpath("//div[@class= 'success show']"));
        return successRE.getText();
    }

    public void clickDeleteBtn() {
        WebElement clickDB = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title= 'Delete this playlist']")));
        //WebElement clickDeleteBtn = driver.findElement(By.xpath("//button[@title= 'Delete this playlist']"));
       clickDB.click();
    }
    public void clickPlayList(){
        WebElement clickPL = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class= 'playlist playlist']//a[contains(text(), '12')]")));
       // WebElement clickPlayList = driver.findElement(By.xpath("//li[@class= 'playlist playlist']//a[contains(text(), '12')]"));
        clickPL.click();
    }
}

