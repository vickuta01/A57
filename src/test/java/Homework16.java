import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {
     //Pre-Condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
     //Chrome Driver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      //Steps
      //Step 1= Open Browser
        String url = "https://qa.koel.app/";
        driver.get(url);
      //Step 2= Click Registration
        WebElement registration = driver.findElement(By.xpath("//div[@class='text-center mt-2 small']"));
        registration.click();
      // Result
        WebElement result = driver.findElement(By.xpath("//div[@class='login-wrapper']"));
        Assert.assertTrue(result.isDisplayed());
      // Close the Browser
        driver.quit();




    }
}
