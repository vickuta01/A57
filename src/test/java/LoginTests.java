/*import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailEmptyPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword(" ");
        loginPage.clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test
    public void successfullyLoginTest(){

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickLoginBtn();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }

    @Test
    public void loginInvalidEmailPasswordTest(){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickLoginBtn();

        Assert.assertEquals(driver.getCurrentUrl(),url);
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Test

    public void successfulLoginPF(){

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickLoginBtn();
        Assert.assertTrue(homePage.clickAvatarIcon().isDisplayed());
    }
} */
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickLoginBtn();


    }

    @Test
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("nemanja.sijacic@testpro.io");
                loginPage.providePassword("Vojvodina.021");
                loginPage.clickLoginBtn();


    }

    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("");
        loginPage.clickLoginBtn();



    }

    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickLoginBtn();


    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.provideEmail("nemanja.sijacic@testpro.io");
        loginPage.providePassword("Vojvodina.021");
        loginPage.clickLoginBtn();


    }
}
