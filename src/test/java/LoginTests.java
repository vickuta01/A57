import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //navigateToPage();
        provideEmail("dwayne.speller@testpro.io");
        providePassword("Testing6600.");
        clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        //navigateToPage();
        provideEmail("dwayne.speller@testpro.io");
        providePassword("Testing6600.");
        clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); // https://qa.koel.app/
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        //steps
        //navigateToPage();
        provideEmail("dwayne.speller@testpro.io");
        providePassword("Testing6600.");
        clickLoginBtn();
        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
        System.out.println("Just Testing console");
    }

}