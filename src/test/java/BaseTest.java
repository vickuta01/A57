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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.URI;
import java.time.Duration;
import java.net.MalformedURLException;
import java.util.UUID;


public class BaseTest {
    public static WebDriver driver;
    WebDriverWait wait;
    public Actions actions = null;
    public String url = null;
    String newPlaylistName = "Good Song";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.firefoxdriver().setup();

    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser (String BaseURL)throws MalformedURLException {

            driver = pickBrowser(System.getProperty("browser"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            url = BaseURL;
            driver.get(url);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actions = new Actions(driver);
        }
        @AfterMethod
        public void closeBrowser () {
            driver.quit();
        }
        public void navigateToPage(String url) {
            driver.get(url);
        }
        public static WebDriver pickBrowser (String browser) throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            String gridURL = "http://10.0.0.105:4444";
            switch (browser) {
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

        public void clickLoginBtn () {
            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            submit.click();
        }
        public void providePassword (String password){
            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
            passwordField.sendKeys(password);
        }
        public void provideEmail (String email){
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
            emailField.sendKeys(email);
        }
        public void navigateToPage () {
            String url = "https://qa.koel.app/";
            driver.get(url);
        }
        public void choosePlaylist () {
            WebElement chooseAnyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'song')]")));
            chooseAnyPlaylist.click();
        }
        public void clickAddToBtn () {
            WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-add-to")));
            addToBtn.click();
        }
        public void clickTheFirstSong () {
            WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper  td.title")));
            firstSong.click();
        }
        public void clickViewAllBtn () {
            WebElement viewAllSearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button")));
            viewAllSearch.click();
        }
        public void searchSong (String song){
            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
            search.sendKeys(song);
        }
        public String getNotificationText () {
            WebElement notificationT = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
            return notificationT.getText();
        }
        public void clickAvatorIcon () {
            WebElement avatarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[class='avatar']")));
            avatarIcon.click();
        }
        public String generateRandomName () {
            return UUID.randomUUID().toString().replace("-", "");
        }
        public void provideCurrentPassword (String password){
            WebElement currentPassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='current_password']")));
            currentPassword.clear();
            currentPassword.sendKeys(password);
        }
        public void provideProfileName (String newProfileName){
            WebElement profileName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileName']")));
            profileName.clear();
            profileName.sendKeys(newProfileName);
        }
        public void clickOnSaveBtn () {
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-submit']")));
            saveBtn.click();
        }
        //Mouse Hover
        public WebElement clickPlayBtn () {
            WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
            actions.moveToElement(playButton).perform();
            return wait.until(ExpectedConditions.visibilityOf(playButton));
        }
        public void clickDeletePlaylistBtn () {
            WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del.btn-delete-playlist")));
            deletePlaylistBtn.click();
        }
        public void clickAnyPlaylist () {
            WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
            clickPlaylist.click();
        }
        public void registrationLinkClick () {
            WebElement registrationLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='registration']")));
            registrationLink.click();
        }
        public boolean isSongPlaying () {
            WebElement soundBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='sound-bar-play']")));
            return soundBar.isDisplayed();
        }
        public void enterNewPlaylistName () {
            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
            inputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
            inputField.sendKeys(newPlaylistName);
            inputField.sendKeys(Keys.ENTER);
        }
        public void doubleClickPlaylist () {
            WebElement dblClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
            actions.doubleClick(dblClick).perform();
        }
        public String getRenamePlaylistSuccessMsg () {
            WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
            return notification.getText();
        }
    }
