import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
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
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        navigateToPage();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void provideEmail(String email) {
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickLoginBtn() {
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
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























