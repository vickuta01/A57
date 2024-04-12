package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
////////////////////////////////////////////////////////
   // By emailField = By.cssSelector("[type='email']");
    //By passwordField = By.cssSelector("[type='password']");
   // By loginBtn = By.cssSelector("[type='submit']");
//////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////
    //public void provideEmail(String email){
        //findElement(emailField).sendKeys(email);
    //}
   // public void providePassword(String password){
        //findElement(passwordField).sendKeys(password);
    //}
    //public void  clickSubmit(){
        //findElement(loginBtn).click();
    //}public void login(){
        //provideEmail("nina.vantsa@testpro.io");
        //providePassword("Parasolka2006@");
        //clickSubmit();
    //}

////////////////////////////////////////////////////////////
    @FindBy(css = "[type='email']")
    WebElement emailLocator;
    @FindBy(css = "[type='password']")
    WebElement passwordLocator;
    @FindBy(css = "[type='submit']")
    WebElement loginBtnLocator;

     public void provideEmailLocator(String email){
        emailLocator.clear();
        emailLocator.sendKeys(email);
    }
    public void providePasswordLocator(String password){
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
    }
    public void submitBtnLocator(){
        loginBtnLocator.click();
    }
    public void login(){
        provideEmailLocator("nina.vantsa@testpro.io");
        providePasswordLocator("Parasolka2006@");
        submitBtnLocator();
    }
}
