import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.bouncycastle.cms.RecipientId.password;

public class BaseTest {

    protected static WebDriver driver = null;
    public WebDriverWait wait = null;
    //public String url = "https://qa.koel.app/";
    public static Actions actions = null;
    //public static WebDriver driver = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters("baseUrl")
    public void lunchBrowser(String baseUrl) throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized", "-lang=en");
        //driver = new ChromeDriver(options);
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        getDriver().get(baseUrl);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //actions = new Actions(driver);
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
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    private WebDriver pickBrowser(String browserName) throws MalformedURLException {
        String gridURL = "http://192.168.1.212:4444";
        browserName = browserName.toLowerCase();

        switch (browserName) {
            case "grid-edge":
                return createRemoteEdgeDriver(gridURL);
            case "grid-chrome":
                return createRemoteChromeDriver(gridURL);
            case "edge":
                return createEdgeDriver();
            case "chrome":
                return createChromeDriver();
            //case "cloud":
            //return lambdaTest();
            default:
                throw new IllegalArgumentException("Invalid browserName: " + browserName);
        }
    }

    private WebDriver createRemoteEdgeDriver(String gridURL) throws MalformedURLException {
        WebDriverManager.edgedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "MicrosoftEdge");
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:edgeChromium", true);
        edgeOptions.addArguments("--start-maximized", "--disable-notifications", "--inprivate", "-lang=en");
        capabilities.merge(edgeOptions);
        return new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
    }

    private WebDriver createRemoteChromeDriver(String gridURL) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
    }

    private WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized", "--disable-notifications", "--remote-allow-origins=*", "-lang=en");
        return new EdgeDriver(options);
    }

    private WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        ChromeOptions optionsChromeLocal = new ChromeOptions();
        optionsChromeLocal.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized", "-lang=en");
        capabilities.setCapability(ChromeOptions.CAPABILITY, optionsChromeLocal);
        return new ChromeDriver(optionsChromeLocal);
    }


    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "@hub.lambdatest.com/wd/hub";
        String userName = "nina.vantsa";
        String acsessKey = "AVJLs4aHuf7SIPjfk7d4BJ4BeqWB8sIOZU8HCR8rmeMnJV4iJs";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "123.0");

        /*ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("123.0");*/
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "nina.vantsa");
        ltOptions.put("accessKey", "AVJLs4aHuf7SIPjfk7d4BJ4BeqWB8sIOZU8HCR8rmeMnJV4iJs");
        ltOptions.put("project", "A57 Automation");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        //browserOptions.setCapability("LT:Options", ltOptions);
        capabilities.setCapability("LT:Optoinc", ltOptions);
        return driver = new RemoteWebDriver(new URL("https://" + userName + ":" + acsessKey + hubURL), capabilities);

    }
}
