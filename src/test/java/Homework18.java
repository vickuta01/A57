import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {


        provideEmail("nina.vantsa@testpro.io");
        Thread.sleep(2000);
        providePassword("Parasolka2006@");
        Thread.sleep(2000);
        clickSubmitBtn();
        Thread.sleep(2000);
        clickPlayBtn();
        Assert.assertTrue(songPlaying());


    }



    public boolean songPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();

    }


    public void clickPlayBtn() {

        WebElement clickPlayNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement clickPlayBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        clickElementWithJavaScript(clickPlayNextSong);
        clickElementWithJavaScript(clickPlayBtn);

    }

    public void clickElementWithJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

    }
}

