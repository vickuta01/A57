import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.bouncycastle.cms.RecipientId.password;

public class BaseTest {

    protected WebDriver driver = null;
    public WebDriverWait wait;
    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters("baseUrl")
    public void lunchBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized", "-lang=en");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        driver.get(baseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickSubmitBtn() {
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']")));
        //WebElement submitBtn = driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}


