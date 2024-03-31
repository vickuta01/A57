import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class LoginTests extends BaseTest{
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {
        //added chromeOptions argument bellow to fix websocket error
        //step 2: enter email
        WebElement emailField= driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("");
        Thread.sleep(2000);
        //step 3: enter password
        WebElement passwordField= driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        Thread.sleep(2000);
        //step 4: click on login
        WebElement loginBtn=driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        //step 5: expected vs actual

        Assert.assertEquals(driver.getCurrentUrl(),url);
        System.out.println("Just Testing Console");
        Thread.sleep(2000);
        //step 6: close browser
        driver.quit();
    }
    @Test

    public void loginValidEmailPassword()throws InterruptedException{

        //step 2: enter email
        WebElement emailField= driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");
        Thread.sleep(2000);
        //step 3: enter password
        WebElement passwordField= driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        Thread.sleep(2000);
        //step 4: click on login
        WebElement loginBtn=driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        //step 5: expected vs actual
        WebElement avatarIcon=driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        Thread.sleep(2000);
        //step 6: close browser
        driver.quit();
    }

    @Test
    public void loginInvalidEmailPassword() throws InterruptedException{
        //pre-condition


        //step 2: enter email
        WebElement emailField= driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("incorrectemail@class.com");
        Thread.sleep(2000);
        //step 3: enter password
        WebElement passwordField=driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        Thread.sleep(2000);
        //step 4: click on login
        WebElement loginBtn=driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        //step 5: expected vs actual
        Assert.assertEquals(driver.getCurrentUrl(),url);
        Thread.sleep(2000);
        //step 6: close browser
        driver.quit();


    }
}