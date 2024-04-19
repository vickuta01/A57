import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest{
    @Test
    public void renamePlayListHomework23(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        String newPlayListName = "IDidIt";
        String updatedPlayListMsg = "Updated playlist \"IDidIt.\"";


        loginPage.provideEmailLocator("nina.vantsa@testpro.io");
        loginPage.providePasswordLocator("Parasolka2006@");
        loginPage.submitBtnLocator();
        homePage.doubleClickLocator();
        homePage.cleanEnterListLocator(newPlayListName);
        Assert.assertEquals(homePage.getRenamedListLocator(), updatedPlayListMsg);

    }
}
