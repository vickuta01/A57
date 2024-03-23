import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class Homework16 extends BaseTest{
    public void registrationNavigation (){
        //preconditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments(" -- remote-allow-origins=*");

        //Chrome driver

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        //step 1
        String url= "https://qa.koel.app/";
        driver.get(url);
        //Step2

        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']");
        registrationLink.click();
        //step 3
        String url2 = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),url2);
        //step4
        driver.quit();





    }



}
