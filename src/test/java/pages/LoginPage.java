package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By loginBtn = By.cssSelector("[type='submit']");

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void  clickSubmit(){
        findElement(loginBtn).click();
    }
    public void login(){
        provideEmail("nina.vantsa@testpro.io");
        providePassword("Parasolka2006@");
        clickSubmit();
    }



}
