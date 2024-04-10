import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {

    @Test
    public void renamePlayListHomework22() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        String newPlayListName = "IDidIt";
        String updatedPlayListMsg = "Updated playlist \"IDidIt.\"";


        loginPage.provideEmail("nina.vantsa@testpro.io");
        loginPage.providePassword("Parasolka2006@");
        loginPage.clickSubmit();
        Thread.sleep(5);
        homePage.doubleClickSelectedPL();
        Thread.sleep(5);
        homePage.cleanAndEnterNewNave(newPlayListName);
        Assert.assertEquals(homePage.getRenamedNewPlayList(), updatedPlayListMsg);

    }


}