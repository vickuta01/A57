import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public String url;

    //= "https://qa.koel.app/";

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseURL;
        navigateToPage();
        Thread.sleep(1000);

    }

    public void navigateToPage() {
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void clickLogIn() {
        WebElement logInBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        logInBtn.click();

    }

    public void searchSong(String songName) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public void clickViewAll() {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("section.songs > h1 > button"));
        viewAllBtn.click();

    }

    public void clickFirstSong()
    {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//td[@class='title']"));
        firstSong.click();
    }

    public void clickAddTo()
    {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
    }

    public void  addToPlayList(String playListName)
    {
        //Created Playlist - 'Test1'
        WebElement playListNameField = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test1')]"));
        playListNameField.click();
    }

    public String getSuccessAlertMessage()
    {
        WebElement successAlertMessage = driver.findElement(By.xpath("//div[@class='success show']"));
        return successAlertMessage.getText();
    }

    public void playNextSong() throws InterruptedException
    {
        WebElement playerControlsBtn = driver.findElement(By.cssSelector("#mainFooter div[class='side player-controls']"));
        playerControlsBtn.click();
        Thread.sleep(1000);
        WebElement playNextSongBtn = driver.findElement(By.cssSelector("#mainFooter span[class='play']"));
        playNextSongBtn.click();
    }

    public boolean isSoundBarVisible()
    {
        WebElement soundBar = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
        return soundBar.isDisplayed();
    }

    public void deleteFromPlaylist(String playList) throws InterruptedException {
        //Delete Playlist - 'Test1'
        WebElement playListNameElement = driver.findElement(By.xpath("//section[@id='playlists']//a[text()='" + playList + "']"));
        playListNameElement.click();
        WebElement deletePlaylist= driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deletePlaylist.click();

    }


}