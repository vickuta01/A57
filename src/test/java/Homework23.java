import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{





        @Test
        public void loginWithValidEmailAndPassword(){
            LoginPage loginPage=new LoginPage(driver);
            HomePage homePage=new HomePage(driver);

            loginPage.provideEmailToLogin("habtom.fesseha@testpro.io");
            loginPage.providePasswordToLogin("Econ@99336");
            loginPage.clickSubmitBtn();

            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        }

    }


