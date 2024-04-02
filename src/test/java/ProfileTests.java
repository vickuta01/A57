/*import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

     @Test(groups = "ProfileTests")
     public void changeProfileName() throws InterruptedException {
          openUrl();
          enterEmail("demo@class.com");
          enterPassword("te$t$tudent");
          clickLoginBtn();
          Thread.sleep(1000);
          // open profile
          WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
          avatarIcon.click();
          // type password
          WebElement currentPasswordInput = driver.findElement(By.id("inputProfileCurrentPassword"));
          currentPasswordInput.click();
          currentPasswordInput.clear();
          currentPasswordInput.sendKeys("te$t$tudent");
          // type new name
          String name = generateRandomName();
          System.out.println(name);
          WebElement profileName = driver.findElement(By.cssSelector("#inputProfileName"));
          profileName.click();
          profileName.clear();
          profileName.sendKeys(name);
          // type email
          WebElement emailInput = driver.findElement(By.cssSelector("#inputProfileEmail"));
          emailInput.click();
          emailInput.clear();
          emailInput.sendKeys("demo@class.com");
          // click save
          WebElement saveBtn = driver.findElement(By.cssSelector(".btn-submit"));
          saveBtn.click();
          // assert profile name is new
          driver.navigate().refresh();
          WebElement profile = driver.findElement(By.cssSelector(".view-profile>span"));
          String newName = profile.getText();
          Assert.assertEquals(newName, name);
     }
}*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest{

     @Test
     public void changeProfileName() throws InterruptedException {
          //Login To Koel
          openUrl();
          enterEmail("demo@class.com");
          enterPassword("te$t$tudent");
          //provideEmail("demo@class.com");
         // providePassword("te$t$tudent");
          clickLoginBtn();
          Thread.sleep(2000);
          //click on Avatar Icon to navigate to Profile
          clickOnAvatarIcon();
          Thread.sleep(2000);
          //Generate Random Name for Profile
          String randomName = generateRandomName();
          System.out.println("Randon name is: "+randomName);
          //Current Password
          provideCurrentPassword("te$t$tudent");
          Thread.sleep(2000);
          //provide new Generated name
          provideProfileName(randomName);
          Thread.sleep(2000);
          //click on Save button
          clickOnSaveBtn();
          Thread.sleep(2000);
          //Assertions (Actual vs Expected)
          WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
          Thread.sleep(2000);
          Assert.assertEquals(actualProfileName.getText(), randomName);
     }

     public void clickOnAvatarIcon() {
          WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
          avatarIcon.click();
     }

     public String generateRandomName(){
          return UUID.randomUUID().toString().replace("-", ""); //adkskldjsad23dmdj
     }

     public void provideCurrentPassword(String currentPassword){
          WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password']"));
          currentPasswordField.clear();
          currentPasswordField.sendKeys(currentPassword);
     }

     public void provideProfileName(String newProfileName){
          WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
          profileName.clear();
          profileName.sendKeys(newProfileName);
     }

     public void clickOnSaveBtn(){
          WebElement saveBtn = driver.findElement(By.cssSelector("button.btn-submit"));
          saveBtn.click();
     }


}