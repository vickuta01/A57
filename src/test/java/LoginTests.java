import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {

        provideEmail(" ");
        providePassword(" ");
        clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), url);
      //  driver.quit();
    }
@Test
    public void loginValidEmailPassword() throws InterruptedException {

        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();
        Thread.sleep(2000);


        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }


    @Test
    public void loginInvalidEmailPassword() throws InterruptedException{
                    //Steps
        provideEmail("k.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();
        Thread.sleep(2000);//Open browser


        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
@Test
    public void loginValidEmailInvalidPassword() throws InterruptedException{

    provideEmail("kseniya.potsina@testpro.io");
    providePassword("testproA");
    clickLoginBtn();
    Thread.sleep(2000);//Open browser

       Assert.assertEquals(driver.getCurrentUrl(),url);

    }

}
