import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

   /* @Test
    public void loginValidEmailEmptyPassword() {

//      Added ChromeOptions argument below to fix websocket error
     provideEmail("agnes.albertusiak@testpro.io");
     providePassword("");
     clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(), url);

    }*/
    @Test
    public void loginValidEmailEmptyPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("agnes.albertusiak@testpro.io");
        loginPage.providePassword(" ");
        loginPage.clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    /*@Test
    public void successfullLogin(){
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());


    }*/

    //successfull login with POM
    @Test
    public void successfullLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("agnes.albertusiak@testpro.io");
        loginPage.providePassword("4Ameryka4aska!");
        loginPage.clickLoginBtn();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
   /* @Test
    public void loginInvalidEmailPassword() {
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("testPro");
        clickLoginBtn();
       Assert.assertEquals(driver.getCurrentUrl(),url);

    }*/
    @Test
    public void loginInvalidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("agnes.albertusiak@testpro.io");
        loginPage.providePassword("testPro");
        loginPage.clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
}
