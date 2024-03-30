import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() {
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        clickPlayBtn();

        WebElement soundBar = driver.findElement(By.cssSelector("[alt='Sound bars']"));
        Assert.assertTrue(soundBar.isDisplayed());

    }

}
