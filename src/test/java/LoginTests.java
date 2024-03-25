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
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

   @Test
    public void loginValidEmailPassword(){
        //pre-condition
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--allow-remote-origins=*");
       System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        //chrome driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //steps
        //step 1: open browser

        String url="https://qa.koel.app/";
        driver.get(url);
        //step 2: enter email
        WebElement emailField= driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(
         "demo@class.com");

        //step 3: enter password
        WebElement passwordField= driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(
                "te$t$tudent");
        //step 4: click on login
        WebElement loginBtn=driver.findElement(By.cssSelector("button[type='submit]"));
        loginBtn.click();
        //step 5: expected vs actual
        WebElement avatarIcon=driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //close the  browser
        driver.quit();

    }
}
