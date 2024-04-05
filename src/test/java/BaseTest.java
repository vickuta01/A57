import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.bouncycastle.cms.RecipientId.password;

public class BaseTest {

    public WebDriver driver;
    public String url = "https://qa.koel.app/";
    public WebDriverWait wait = null;
    //public String url = "https://qa.koel.app/";
    public static Actions actions = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void lunchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().minimize();
    }


    public void clickSubmitBtn() {
        WebElement submitBtn = driver.findElement(By.xpath("//div[@id='app']//button[@type='submit']"));
        submitBtn.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToPage() {
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

