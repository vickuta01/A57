import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //navigateToPage();
        provideEmail("pearl.estrada@testpro.io");
        providePassword("April969!!");
        clickLoginBtn();

        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurentUrl(), url);
    }
    @Test
    public void loginValidEmptyPassword() throws InterruptedException {
        //navigateToPage();
        provideEmail("pearl.estrada@testpro.io");
        providePassword("");
        clickLoginBtn();

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}