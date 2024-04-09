import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19Test {

    @Test
    @Parameters({"BaseURL"})
    public void deletePlaylist() throws InterruptedException {

        ///Pre-Condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //ChromeDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ***TEST STEPS***

        //STEP 1: OpenBrowser
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);


        //STEP 2: Login using valid credentials
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("elliott.nance@testpro.io");
        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("HondaAccord2024$");
        Thread.sleep(2000);

        WebElement submitBtn = driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();
        Thread.sleep(2000);


        //STEP 3: Click on playlist to delete
        WebElement clickPlaylist = driver.findElement(By.cssSelector("a[href='#!/playlist/93447']"));
        clickPlaylist.click();
        Thread.sleep(2000);

        //STEP 4: Click on red "x" button to delete playlist
        WebElement clickDeleteBtn = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        clickDeleteBtn.click();
        Thread.sleep(2000);

        //STEP 6: Click "ok" button to delete playlist
        WebElement okToDeleteBtn = driver.findElement(By.cssSelector("button[class='ok']"));
        okToDeleteBtn.click();
        Thread.sleep(2000);

        //STEP 6: Validate playlist is deleted
        WebElement songPlaying = driver.findElement(By.cssSelector("div[class='success show']"));
        Thread.sleep(2000);

       //STEP 6: Close Browser
        driver.quit();

    }
}
