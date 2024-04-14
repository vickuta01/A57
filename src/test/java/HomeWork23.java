import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeWork23 extends BaseTest{
    @Test
    public void implementPageFactory (){
        String result = "Deleted playlist \"Test.\"";
        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //fluent interface
        loginpage.provideEmailLogin("elzat.nurmanbetova@testpro.io")
                .providePasswordLogin("kochkor123-Q!")
                .clickSubmitButton();
        homePage.playListName("Test").deleteExistingPlaylist().getDeletedMessage();

        Assert.assertEquals(homePage.getDeletedMessage(),result);
    }

}
