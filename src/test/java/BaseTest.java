import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {
    public WebDriver driver;
    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void launchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void clickLoginBtn() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement chooseAnyPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'summer')]"));
        chooseAnyPlaylist.click();
        Thread.sleep(2000);
    }

    public void clickAddToBtn() throws InterruptedException{
        WebElement addToBtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    public void clickTheFirstSong() throws InterruptedException{
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper  td.title"));
        firstSong.click();
        Thread.sleep(5000);
    }

    public void clickViewAllBtn() throws InterruptedException{
        WebElement viewAllSearch = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearch.click();
        Thread.sleep(5000);
    }

    public void searchSong(String song)throws InterruptedException{
        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.sendKeys(song);
        Thread.sleep(2000);
    }

    public String getNotificationText() {
        WebElement notificationT = driver.findElement(By.cssSelector("div.success.show"));
        return notificationT.getText();
    }

    public void clickAvatorIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        avatarIcon.click();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);

    }

    public void provideProfileName(String newProfileName){
        WebElement profileName = driver.findElement(By.cssSelector("[id='inputProfileName']"));
        profileName.clear();
        profileName.sendKeys(newProfileName);
    }

    public void clickOnSaveBtn(){
        WebElement saveBtn = driver.findElement(By.cssSelector("[class='btn-submit']"));
        saveBtn.click();
    }
}