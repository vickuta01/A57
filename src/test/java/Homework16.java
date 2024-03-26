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
    public void registrationNavigation() throws InterruptedException {
            //precondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //navigate to page
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
          //click the registration link
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();
        Thread.sleep(2000);
           //verify
        String newUrl = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),newUrl);

        driver.quit();

    }
}
