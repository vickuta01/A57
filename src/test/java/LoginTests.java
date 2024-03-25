import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void registrationNavigation() throws InterruptedException {
        ///Pre-Condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //ChromeDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //STEPS
        //Step 1: OpenBrowser
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        //Step 2: Click on Registration Link
        WebElement registrationBtn = driver.findElement(By.cssSelector("[href='registration']"));
        registrationBtn.click();
        //Step 3: Enter Email
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("elliott.nance+3@testpro.io");
        Thread.sleep(2000);
        //Step 4: Click on Submit
        WebElement submitBtn = driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();
        //Step 5:Expected Result
        WebElement successMsg = driver.findElement(By.cssSelector("div[class='messages']"));

        //Close the browser
        driver.quit();
    }
}

