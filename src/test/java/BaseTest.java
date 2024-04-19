/*import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import javax.swing.*;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver;

    private static final ThreadLocal<WebDriver> threadDriver= new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    WebDriverWait wait;
    public Actions actions= null;
    public String url = null;
    String newPlaylistName = "Summer2024";
    @BeforeSuite
    static void setupClass() {

    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser (String BaseURL)throws MalformedURLException{


        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        url = BaseURL;
        driver.get(url);
        getDriver().get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        actions = new Actions(driver);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }
    public static WebDriver pickBrowser (String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://10.0.0.105:4444";
        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--incognito");
                edgeOptions.addArguments("--start-maximized");
                return driver = new EdgeDriver(edgeOptions);
            // GRID cases
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
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

    public static WebDriver lambdaTest() throws MalformedURLException{
        String hubURL ="http://hub.lambdatest.com/wd/hub";
        String userName ="nemanja.sijacic";
        String accessKey ="Vg6wA9dEue771quLvSJiXNN3b50q1UYhNSQTLIDFK7NQQ75XXB";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "123.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "nemanja.sijacic");
        ltOptions.put("accessKey", "Vg6wA9dEue771quLvSJiXNN3b50q1UYhNSQTLIDFK7NQQ75XXB");
        ltOptions.put("project", "Koel Automation");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        capabilities.setCapability("LT:Options", ltOptions);

        return driver= new RemoteWebDriver(new URL(hubURL), capabilities);
    }
    public void clickLoginBtn() {
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submit.click();
    }
    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
    }
    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
    }
    public void navigateToPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
    public void choosePlaylist() {
        WebElement chooseAnyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'summer')]")));
        chooseAnyPlaylist.click();
    }
    public void clickAddToBtn() {
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-add-to")));
        addToBtn.click();
    }
    public void clickTheFirstSong() {
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper  td.title")));
        firstSong.click();
    }
    public void clickViewAllBtn() {
        WebElement viewAllSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button")));
        viewAllSearch.click();
    }
    public void searchSong(String song){
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        search.sendKeys(song);
    }
    public String getNotificationText() {
        WebElement notificationT = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return notificationT.getText();
    }
    public void clickAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[class='avatar']")));
        avatarIcon.click();
    }
    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    public void provideCurrentPassword(String password) {
        WebElement currentPassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='current_password']")));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }
    public void provideProfileName(String newProfileName){
        WebElement profileName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileName']")));
        profileName.clear();
        profileName.sendKeys(newProfileName);
    }
    public void clickOnSaveBtn(){
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-submit']")));
        saveBtn.click();
    }
    //Mouse Hover
    public WebElement clickPlayBtn() {
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playButton).perform();
        return wait.until(ExpectedConditions.visibilityOf(playButton));
    }
    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
        deletePlaylistBtn.click();
    }
    public void clickAnyPlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        clickPlaylist.click();
    }
    public void registrationLinkClick() {
        WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='registration']")));
        registrationLink.click();
    }
    public boolean isSongPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
    }
    public void enterNewPlaylistName() {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        inputField.sendKeys(newPlaylistName);
        inputField.sendKeys(Keys.ENTER);
    }
    public void doubleClickPlaylist() {
        WebElement dblClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(dblClick).perform();
    }
    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
} */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    private WebDriver driver;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
        getThreadLocal().get(baseURL);
        System.out.println(
                "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "";
        String authkey = "";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "110.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.2.127.17:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
        }
    }

    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
}