import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest {
    @Test
    public void deletePlayList() {

        String expectedDeletedMsg = "Deleted playlist \"Test.\"";

        //GIVEN
        provideEmail("elzat.nurmanbetova@testpro.io");
        providePassword("kochkor123-Q!");
        clickLoginBtn();

        //WHEN
        clickPlayList("Test");
        deletePlayButton();


        getDeletedMsg();
        Assert.assertEquals(getDeletedMsg(), expectedDeletedMsg);

    }

    public void clickPlayList(String playListName) {
        // WebElement playListElement = driver.findElement(By.xpath("//a[@href='"));
        WebElement playListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#!/playlist/93358']")));
        playListElement.click();

    }

    public void deletePlayButton() {
        //WebElement deletePlayBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        WebElement deletePlayBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deletePlayBtn.click();
    }

    public String getDeletedMsg() {
        //WebElement resultNoticeMsg = driver.findElement(By.xpath("//div[@class='success show']"));
        WebElement resultNoticeMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        return resultNoticeMsg.getText();

    }
}
//
