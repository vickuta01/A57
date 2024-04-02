import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        setUpBrowser();
        openUrl();
        String url = "https://qa.koel.app/";
        clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword() {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        setUpBrowser();
        // Steps
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
        driver.quit();
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        setUpBrowser();
        openUrl();
        // Steps
        enterEmail("invalid@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
        // Post-condition
        driver.quit();
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        setUpBrowser();
        // Steps
        openUrl();
        enterEmail("demo@class.com");
        clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        String url = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/

        // Post-condition
        driver.quit();
    }
}

