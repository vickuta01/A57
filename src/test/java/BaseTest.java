package Homework17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implictlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage();
    }

    @AfterMethod
    public void CloseBrowser() {
    driver.quit();
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String Password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickLoginBtn() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public void searchSong(String songName) {
        WebElement submit = driver.findElement(By.cssSelector("input[type='Search']"));
        searchField.clear();
        searchField.sendKeys(songName);
    }

    public void clickViewAll() {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("section.songs>h1>button"));
        viewAllBtn.click();
    }

    public void clickFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']td[@class=title']"));
        firstSong.click();
    }

    public void clickAddTo() {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
    }

    public void addToPlaylist(String playlistName) {
        WebElement playListNameField = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//input[@placeholder='Playlist name']"));
        playlistName.clear();
        playlistName.sendKeys(playListName);
        WebElement saveBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@type='submit']"));
        saveBtn.click();
    }

    public String successAlertMessage() {
        WebElement successAlertMessage = driver.findElement(By.xpath("//div[@class='Success show']"));
        return successAlertMessage.getText();

    }
}