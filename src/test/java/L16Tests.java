import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class L16Tests extends BaseTest{


    @Test(enabled = false,description = "Test skipped for a moment.")
    public void loginEmptyEmailPassword() throws InterruptedException {
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(2000);

        String url ="https://qa.koel.app/";
        driver.get(url);
        // Assert.assertEquals(driver.getCurrentUrl(),url);
        //driver.quit();
        Thread.sleep(2000);
        WebElement emailField=driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("");
        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        Thread.sleep(2000);

        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),url);
        driver.quit();

    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String url="https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalidemail@class.com");
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$tStudent");
        Thread.sleep(2000);
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),url);

        driver.quit();

    }

    @Test
    public void loginValidEmailPassword(){
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickLoginBtn();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }




    @Test
    public void loginInvalidEmailPassword(){
        //navigateToPage();
        provideEmail("invalidemail@class.com");
        providePassword("te$tStudent");
        clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(),url);

    }



    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void clickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public void clickOnLoginBtn(){
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

}
