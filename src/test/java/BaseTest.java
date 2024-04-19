import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String url = null;
    public static Actions actions = null;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    //"https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String baseURL) throws MalformedURLException {

        threadDriver.set(pickBrowser(System.getProperty("browser")));
        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        url = baseURL;
        navigateToPage();

    }
    public static void navigateToPage() {
        getDriver().get(url);
    }


    @AfterMethod
    public void TearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.43:4444";

        switch(browser)
        {
            case "MicrosoftEdge": //gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--incognito");
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new EdgeDriver(edgeOptions);

            case "grid-edge": //gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(chromeOptions);

        }
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubUrl = "@hub.lambdatest.com/wd/hub";
        String userName = "sakthibala.sengottiyan";
        String accessKey = "NZjfXgHyM92Hc7c4hLbGMxxinzg49xxMQFTbzYkH56g0T6ya52";

        //Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("browserVersion","123.0");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("build", "Cloud Test");
        ltOptions.put("project", "Homework25");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        capabilities.setCapability("LT:Options", ltOptions);

        return driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + hubUrl), capabilities);


    }

}