import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework16 extends BaseTest {
    @Test
    public void testRegistrationNavigation(){
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        //setUpBrowser();
        // Steps
        openUrl();
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();

        String expectedRegistrationUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), expectedRegistrationUrl);
        driver.quit();

    }



}
