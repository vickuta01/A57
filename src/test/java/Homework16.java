import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest{

    @Test

    public void registrationNavigation() {

        String registrationURl = "https://qa.koel.app/registration";

        registrationLinkClick();
        Assert.assertEquals(getDriver().getCurrentUrl(),registrationURl);
    }


}
