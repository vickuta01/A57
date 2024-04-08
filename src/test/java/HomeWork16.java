import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class HomeWork16 {

    @Test
    public void registrationNavigation() throws InterruptedException {

//precondition: open browser
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");

      WebDriver driver = new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//Navigate to website
      String url = "https://qa.koel.app/";
      driver.get(url);
      Thread.sleep(2000);

//Click the registration link
      WebElement registrationLink = driver.findElement(By.cssSelector("a[href*='registration']"));
      registrationLink.click();
      Thread.sleep(2000);


//Expected vs Actual
        String url1 = "https://qa.koel.app/registration";
       Assert.assertEquals(driver.getCurrentUrl(),url1);
       Thread.sleep(2000);

//Close the browser
       driver.quit();







    }
}
