import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailEmptyPassword() {

//      Added ChromeOptions argument below to fix websocket error
     provideEmail("agnes.albertusiak@testpro.io");
     providePassword("");
     clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void successfullLogin(){
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());


    }
    @Test
    public void loginInvalidEmailPassword() {
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("testPro");
        clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
}
