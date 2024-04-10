package POM;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //constructor
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    //Locators
    By emailField= By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn=By.cssSelector("button[type='submit']");

    //Page Methods

    //Page Method 1
    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);

    }
    //Page Method 2
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    //Page Method 3
    public void clickSubmitBtn(){
        findElement(submitBtn).click();
    }

}
