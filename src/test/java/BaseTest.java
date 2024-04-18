import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


 @BeforeMethod
public void launchBrowser() {
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--remote-allow-origins=*");
     WebDriver driver = new ChromeDriver(options);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.manage().window().maximize();
 }
@AfterMethod
    public void closeBrowser {
    driver.quit();
     }




    public void clickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public  void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("Password2026@");
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("tassadit.talbi@testpro.io");
    }

    public void navigateToPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);







    }
}




