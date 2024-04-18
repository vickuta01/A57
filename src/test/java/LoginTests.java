import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        provideEmail("pearl.estrada@testpro.io");
        Thread.sleep(2000);
        providePassword("April969!!");
        Thread.sleep(2000);
        clickLoginBtn();
        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
    @Test
    public void loginInvalidEmailValidPassword()throws InterruptedException {
        //navigateToLoginPage();
        provideEmail("invalidemail@test.com");
        Thread.sleep(2000);
        providePassword("April969!!");
        Thread.sleep(2000);
        clickLoginBtn();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {
        //navigateToLoginPage();
        provideEmail("pearl.estrada@testpro.io");
        Thread.sleep(2000);
        providePassword("");
        Thread.sleep(2000);
        clickLoginBtn();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
