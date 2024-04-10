import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() {
        //GIVEN
        provideEmail("elliott.nance@testpro.io");
        providePassword("HondaAccord2024$");
        clickSubmit();

        ///WHEN
        WebElement clickPlaylist = driver.findElement(By.cssSelector("a[href='#!/playlist/93512']"));
        clickPlaylist.click();
        //Thread.sleep(2000);

        WebElement clickDeleteBtn = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        clickDeleteBtn.click();
        //Thread.sleep(2000);

        WebElement okToDeleteBtn = driver.findElement(By.cssSelector("button[class='ok']"));
        okToDeleteBtn.click();
        //Thread.sleep(2000);

        //THEN
        WebElement songPlaying = driver.findElement(By.cssSelector("div[class='success show']"));
        //Thread.sleep(2000);
    }
}




