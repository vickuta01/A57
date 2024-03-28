import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException {
        //login to koel
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();
        Thread.sleep(2000);
        //click on avatar icon to navigate to profile
        clickOnAvatarIcon();
        // generate random name
        String randomName = generateRandomName();
        //current password
        provideCurrentPassword("testproA57*");
        //provide new generated name
        provideProfileName(randomName);
        //click on save button
        //assertions (actual vs expected)


    }

    public void clickOnAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        avatarIcon.click();
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public void provideCurrentPassword(String currentPassword){
        WebElement currentPasswordField = driver.findElement(By.cssSelector("input[name='current_password']"));
    }
    public void provideProfileName(String newProfileName){
        WebElement profileName= driver.findElement(By.cssSelector("input[id='inputProfileName']"));
    }
}
