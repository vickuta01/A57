import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest{
    @Test
    public void deletePlayList() throws InterruptedException{

        String expectedDeletedMsg = "Deleted playlist \"Testpro playlist.\"";

        //GIVEN
        provideEmail("elzat.nurmanbetova@testpro.io");
        Thread.sleep(2000);

        providePassword("kochkor123-Q!");
        Thread.sleep(2000);

        clickLoginBtn();
        Thread.sleep(2000);
        //WHEN
        clickPlayList("Test");
        Thread.sleep(1000);
        deletePlayButton();
        Thread.sleep(1000);
        deletePlayButton();
        Thread.sleep(1000);

        getDeletedMsg();
        Assert.assertEquals(getDeletedMsg(),expectedDeletedMsg);

    }
    public void clickPlayList (String playListName){
        WebElement playListElement = driver.findElement(By.xpath("//a[@href='#!/playlist/93269']"));
        playListElement.click();

    }
    public void deletePlayButton (){
        WebElement deletePlayBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlayBtn.click();
    }

    public String getDeletedMsg(){
        WebElement resultNoticeMsg = driver.findElement(By.xpath("//div[@class='success show']"));
        return resultNoticeMsg.getText();

    }
    //





}
