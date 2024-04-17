import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    // for parallel execution
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    // THREAD_LOCAL of type ThreadLocal<WebDriver>. ThreadLocal is a mechanism that allows
    // storing and retrieving unique variable values for each thread. In this case,
    // ThreadLocal<WebDriver> will be used to store an instance of WebDriver
    // associated with each thread during test execution.

    public static WebDriver getDriver() {
        return threadDriver.get();
    }


    /*@BeforeSuite
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }*/

    @BeforeMethod
    public void setUpBrowser() throws MalformedURLException{
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--start-maximized");
//
//        driver = new ChromeDriver(options);
        //driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        openUrl();
    }
    public void openUrl() {
        String url = "https://qa.koel.app/";
        getDriver().get(url);
    }
    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }
    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://172.20.10.2:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                return driver = new ChromeDriver(options);
        }
    }
    /*@AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }*/

   /*public void openUrl() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }*/
   public WebDriver lambdaTest() throws MalformedURLException {
       String hubURL = "@hub.lambdatest.com/wd/hub";
       String userName = "greytfly";
       String accessKey = "7wXbxSZgFhBvIA71RRHCu2VmyU978XYiklFp1wlbK1ucJIB75H";
       //Capabilities
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("browserName","chrome");
       capabilities.setCapability("browserVersion","123.0");

//       ChromeOptions browserOptions = new ChromeOptions();
//       browserOptions.setPlatformName("MacOS Monterey");
//       browserOptions.setBrowserVersion("123.0");
       HashMap<String, Object> ltOptions = new HashMap<String, Object>();
       ltOptions.put("username", userName);
       ltOptions.put("accessKey", accessKey);
       ltOptions.put("project", "Untitled");
       ltOptions.put("w3c", true);
       ltOptions.put("plugin", "java-java");
       //browserOptions.setCapability("LT:Options", ltOptions);
       capabilities.setCapability("LT:Options", ltOptions);
       return new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + hubURL), capabilities);
   }
    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }

    public void searchForSong(String text) {
        WebElement searchInput = driver.findElement(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }
    public WebElement waitUntilVisible(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions
                .visibilityOfElementLocated(element));
    }

    /* @BeforeMethod
    @Parameters({"BaseURL"})

    public void setUpBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String url=BaseURL;
        openUrl(url);
    }*/
    // public void openUrl(String url) {
    //     driver.get(url);
    // }

}