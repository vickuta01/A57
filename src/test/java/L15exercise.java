import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class L15exercise extends BaseTest{

  @Test
    public void loginValidEmailPassword(){
      //Pre-condition
      //Add ChromeOptions argument to fix websocket errors
      ChromeOptions options= new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      WebDriver driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //steps

      String url="https://qa.koel.app/";
      driver.get(url);

    WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
    emailField.clear();
    emailField.sendKeys("demo@class.com");
    WebElement passwordField =driver.findElement(By.cssSelector("input[type='password']"));
    passwordField.clear();
    passwordField.sendKeys("te$t$tudent");

    WebElement loginBtn= driver.findElement(By.cssSelector("button[type='submit']"));
    loginBtn.click();

    WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
    Assert.assertTrue(avatarIcon.isDisplayed());
driver.quit();
    }
  @Test
  public void loginInvalidEmailValidPassword() throws InterruptedException {

    ChromeOptions options= new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");

    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    String url="https://qa.koel.app/";
    driver.get(url);
Thread.sleep(2000);
    WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
    emailField.clear();
    emailField.sendKeys("invalidEmail@class.com");
    Thread.sleep(2000);
    WebElement passwordField= driver.findElement(By.cssSelector("input[type='password'"));
    passwordField.clear();
    passwordField.sendKeys("te$t$tudent");

    WebElement loginBtn= driver.findElement(By.cssSelector("button[type='submit']"));
    loginBtn.click();
    Thread.sleep(2000);
    Assert.assertEquals(driver.getCurrentUrl(),url);

    driver.quit();
  }
  //login with empty password
    @Test
  public void loginValidEmailEmptyPassword() throws InterruptedException {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");
      WebDriver driver =new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      String url ="https://qa.koel.app/";
      driver.get(url);

      WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
      emailField.clear();
      emailField.sendKeys("demo@class.com");

      Thread.sleep(2000);

      WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
      passwordField.clear();
      passwordField.sendKeys("");

      Thread.sleep(2000);

      WebElement loginBtn= driver.findElement(By.cssSelector("button[type='submit']"));
      loginBtn.click();

      Assert.assertEquals(driver.getCurrentUrl(),url);

      Thread.sleep(2000);

      driver.quit();

    }
}
