package POM;

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
import org.testng.annotations.Parameters;

import java.time.Duration;
public class BaseTest {

    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    //public String url="https://qa.koel.app/";

    @BeforeSuite
    void setupClass() {
        WebDriverManager.chromedriver().setup();


    }

    //With parameter
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navigateToPage(baseURL);

    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

   /* @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage();

    }*/

    public void navigateToPage() {
        driver.get(url);
    }

    void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    ;

    void clickLoginBtn() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }


    @AfterMethod

    public void closeBrowser() {
        driver.quit();
    }
}





    /*public class BaseTest {

        public static WebDriver driver=null;
        public static String url=null;
        public static WebDriverWait wait=null;
        public static Actions actions=null;
        //public String url="https://qa.koel.app/";

        @BeforeSuite
        void setupClass() {
            WebDriverManager.chromedriver().setup();


        }
        @BeforeMethod
        public void launchBrowser(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            navigateToPage();

        }

        public void navigateToPage() {
            driver.get(url);
        }
        void provideEmail(String email){
            WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            emailField.clear();
            emailField.sendKeys(email);

        }
        void providePassword(String password){
            WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
            passwordField.clear();
            passwordField.sendKeys(password);
        };
        void clickLoginBtn(){
            WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
            submit.click();
        }


        @AfterMethod

        public void closeBrowser(){
            driver.quit();
        }




}*/
