import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.github.javafaker.Faker;
import java.util.Locale;

import java.time.Duration;

public class BaseTest {
    static WebDriver driver;


    @BeforeSuite
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUpBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public void openUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    void clickLoginBtn(){
        WebElement submitLoginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginBtn.click();
        }

    void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
}

    void enterPassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }
    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }

    public void login(String email,String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }
}