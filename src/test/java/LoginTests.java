import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        provideEmail("nemanja.sijacic@testpro.io");
        providePassword("Vojvodina.021 ");
        clickLoginBtn();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertEquals(driver.getCurrentUrl(),url);
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
}
 /*   @Test
    public void successfullLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickLoginBtn();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test
    public void loginInvalidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(),url);
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Test

    public void succesfullLoginPF(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterEmail("nemanja.sijacic@testpro.io").enterPassword("Vojvodina.021").clickSubmitBnt();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
}
*/