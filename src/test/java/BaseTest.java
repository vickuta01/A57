import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
public class BaseTest{
    public WebDriver driver;
    public WebDriverWait wait;
    public String url = "https://qa.koel.app/";
    public Actions actions;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"url"})
    public void launchBrowser(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.get(url);
    }

    //return driver = new RemoteWebDriver(new URL("https://" +userName + ":" +accessKey + hubURL), capabilities);
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    public void searchSong(String songName) {
        //WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public void clickViewAll() {
        WebElement viewAllBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.songs > h1 > button")));
        viewAllBtn.click();

    }

    public void clickFirstSong() {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//td[@class='title']")));
        firstSong.click();
    }

    public void clickAddTo() {
        WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn-add-to']")));
        addToBtn.click();
    }

    public void addToPlayList(String playListName) {
        WebElement playListNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//input[@placeholder='Playlist name']")));
        playListNameField.clear();
        playListNameField.sendKeys(playListName);
        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@type='submit']")));
        saveBtn.click();

    }

    public String successAlertMessage() {
        WebElement successAlertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
        return successAlertMessage.getText();
    }
}