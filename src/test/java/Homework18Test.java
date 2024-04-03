import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18Test {

    @Test
    public void playSong() throws InterruptedException {

        ///Pre-Condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //ChromeDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //STEPS
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


        //STEP 3: Click Play next song button.
        WebElement clickPlayNextSongBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        clickPlayNextSongBtn.click();
        Thread.sleep(2000);

        //STEP 4: Click play button, to play a song
        WebElement clickPlayBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        clickPlayBtn.click();
        Thread.sleep(2000);

        //STEP 5: Validate song is playing.
        WebElement songPlaying = driver.findElement(By.cssSelector("div[data-test='soundbars']"));
        Thread.sleep(2000);

       //STEP 6: Close Browser
        driver.quit();

    }
}
