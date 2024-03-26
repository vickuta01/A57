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
    public void loginValidEmailPassword() throws InterruptedException {
        //Precondition
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--remote-allow-origins=*");

     WebDriver driver = new ChromeDriver(options);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

     //Steps
        //1. Open browser
      String url = "https://qa.koel.app/";
      driver.get(url);
      Thread.sleep(2000);
        //2. Enter email
        WebElement emailField= driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("kseniya.potsina@testpro.io");
        Thread.sleep(2000);
        //3. Enter password
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("testproA57*");
        Thread.sleep(2000);
        //4. Click on login button
        WebElement loginBtn= driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        //5. Expected vs actual
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //close browser
        driver.quit();
    }
@Test
    public void loginInvalidEmailPassword() throws InterruptedException{
          //Precondition
       ChromeOptions options= new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");

       WebDriver driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         //Open browser
       String url = "https://qa.koel.app/";
       driver.get(url);
       Thread.sleep(2000);
        //Enter invalid email
       WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
       emailField.clear();
       emailField.sendKeys("ks.potsina@testpro.io");
       Thread.sleep(2000);
        //Enter password
       WebElement passwordField = driver.findElement(By.cssSelector("input[type ='password']"));
       passwordField.clear();
       passwordField.sendKeys("testproA57*");
       Thread.sleep(2000);
        //Click on login btn
       WebElement loginBtn= driver.findElement(By.cssSelector("button[type='submit']"));
       loginBtn.click();
       Thread.sleep(2000);
        //Expected vs actual
        Assert.assertEquals(driver.getCurrentUrl(),url);
         //close the browser
        driver.quit();
    }
@Test
    public void loginValidEmailInvalidPassword() throws InterruptedException{
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");

       WebDriver driver=new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       String url="https://qa.koel.app/";
       driver.get(url);
       Thread.sleep(2000);

       WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
       emailField.clear();
       emailField.sendKeys("kseniya.potsina@testpro.io");

       WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
       passwordField.clear();
       passwordField.sendKeys("incorrect");

       WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
       loginBtn.click();
       Thread.sleep(2000);

       Assert.assertEquals(driver.getCurrentUrl(),url);
       Thread.sleep(2000);
       driver.quit();
    }
}
