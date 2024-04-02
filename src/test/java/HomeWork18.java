import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {

    @Test
    public void playSong throws InterruptedExceptionth () {
        //GIVEN
        provideEmail("elzat.nurmanbetova@testpro.io");
        Thread.sleep(2000);
        providePassword("kochkor123-Q!");
        Thread.sleep(2000);

        clickLoginBtn();
        Thread.sleep(2000);

        Assert.assertTrue(isSongPlays());

    }
     //THEN
    public void clickPlay throws InterruptedException() {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@title='Play next song']"));
        playNextBtn.click();
        WebElement playBtn = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        playBtn.click();

    }


    public boolean isSongPlays (){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        soundBar.click();
        return soundBar.isDisplayed();
    }
}
