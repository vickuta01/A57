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
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class BaseTest {

    public WebDriver driver;
    public String url = "https://qa.koel.app/";

    Random rand;
    int randomNum;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser()
    {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
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

    public String generateUniquePlaylistName()
    {
        rand = new Random();
        randomNum = rand.nextInt(1000);
        randomNum += 1;
        return ("Test" + randomNum);

    }

    public void  addToPlayList(String playListName)
    {
        WebElement playListNameField = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//input[@placeholder='Playlist name']"));
        playListNameField.clear();
        playListNameField.sendKeys(playListName);
        WebElement saveBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@type='submit']"));
        saveBtn.click();

    }

    public String getSuccessAlertMessage()
    {
        WebElement successAlertMessage = driver.findElement(By.xpath("//div[@class='success show']"));
        return successAlertMessage.getText();
    }


}