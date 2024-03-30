import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public String url;

    //"https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws InterruptedException {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        url = baseURL;
        navigateToPage();
        //Thread.sleep(1000);

    }

    public void navigateToPage() {
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickLogIn() {
        WebElement logInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        logInBtn.click();

    }

    public void searchSong(String songName) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public void clickViewAll() {
        WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section.songs > h1 > button")));
        viewAllBtn.click();

    }

    public void clickFirstSong()
    {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//td[@class='title']")));
        firstSong.click();
    }

    public void clickAddTo()
    {
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn-add-to']")));
        addToBtn.click();
    }

    public void  addToPlayList(String playListName)
    {
        //Created Playlist - 'Test1'
        WebElement playListNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test1')]")));
        playListNameField.click();
    }

    public String getSuccessAlertMessage()
    {
        WebElement successAlertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        return successAlertMessage.getText();
    }

    public void playNextSong() throws InterruptedException
    {
        WebElement playerControlsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mainFooter div[class='side player-controls']")));
        playerControlsBtn.click();
        //Thread.sleep(1000);
        WebElement playNextSongBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mainFooter span[class='play']")));
        playNextSongBtn.click();
    }

    public boolean isSoundBarVisible()
    {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Sound bars']")));
        return soundBar.isDisplayed();
    }

    public void deleteFromPlaylist(String playList) throws InterruptedException {
        //Delete Playlist - 'Test1'
        WebElement playListNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[text()='" + playList + "']")));
        playListNameElement.click();
        WebElement deletePlaylist= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='del btn-delete-playlist']")));
        deletePlaylist.click();

    }


}