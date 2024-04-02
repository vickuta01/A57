import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest {

    @Test
    public void playSong  () {
        //GIVEN
        provideEmail("demo@class.com");

        providePassword("te$t$tudent");

        clickLoginBtn();

        Assert.assertTrue(isSongPlays());

    }
     //THEN
    public void clickPlay () {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid=='play-next-btn']"));
        playNextBtn.click();
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playBtn.click();

    }


    public boolean isSongPlays (){
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }
}
