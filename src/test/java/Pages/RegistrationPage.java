package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Web Element
    By submitButton = By.cssSelector("input[type='submit']");

    //Helper method
    public WebElement getSubmitBtn () {
        return findElement(submitButton);
    }
}
