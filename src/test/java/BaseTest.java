import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver;
    WebDriverWait wait;
    public String url = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
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

    public void clickAvatorIcon() {
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

    public void clickPlayBtn() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
       playNextButton.click();
        playButton.click();

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
}