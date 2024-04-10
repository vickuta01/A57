import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";


    public  void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='Email Address']"));
        emailField.clear();
        emailField.sendKeys(email);
//        Thread.sleep(2000);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
//            Thread.sleep(2000);
    }

    public void clickSubmit() {
        WebElement submitBtn = driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();
//                Thread.sleep(2000);
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        url = BaseURL;
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}