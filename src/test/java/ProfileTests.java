import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest{

    @Test
    public void changeProfileName() {
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        clickAvatorIcon();
        String randomName = generateRandomName();
        provideCurrentPassword("4Ameryka4aska!");
        provideProfileName(randomName);
        clickOnSaveBtn();

        WebElement actualProfileName = getDriver().findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(),randomName);
    }

}
