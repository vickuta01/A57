package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePages{
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    //webElements
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginBtn = By.cssSelector("button[type='submit']");

    //helper methods

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement(loginBtn).click();

    }
    public void login (){
        provideEmail("elzat.nurmanbetova@testpro.io");
        providePassword("kochkor123-Q!");
        clickSubmit();
    }
}
