package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    By emailField = By.cssSelector("input[type='email']");

    By passwordField = By.cssSelector("input[type='password']");

    By logInBtn = By.cssSelector("button[type='submit']");

    public void provideEmail(String email)
    {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password)
    {
        findElement(passwordField).sendKeys(password);
    }

    public void clickLogIn()
    {
        findElement(logInBtn).click();
    }

    public void login()
    {
        provideEmail("sakthibala.sengottiyan@testpro.io");
        providePassword("Smg6reUh");
        clickLogIn();
    }

}
