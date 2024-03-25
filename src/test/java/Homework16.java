import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

        @Test
        public class Homework16 extends BaseTest {

            public void registrationNavigation() {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                WebDriver driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                String url = "https://testpro.io/";
                driver.get(url);
                WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));

                String registrationUrl = "https://qa.koel.app/registration";
                Assert.assertEquals(driver.getCurrentUrl(), url);

                driver.quit();
                //test changes third time
            }

        }

