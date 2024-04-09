package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    //______________//
    // PAGE Factory //
    //______________//

    @FindBy(css = "input[type='email']")
    WebElement emailFieldLocator;

    @FindBy(css = "input[type='password']")
    WebElement passwordFieldLocator;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtnLocator;



    //Methods
    public void provideEmail(String email){
        findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password){
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }

    public void clickOnSubmitBtn(){
        findElement(submitBtn).click();
    }

    public void login(){
        provideEmail("demo1@class.com");
        providePassword("te$t$tudent");
        clickOnSubmitBtn();
    }

    //Methods using Page Factory Elemets
    public LoginPage clickSubmitBtn(){
        submitBtnLocator.click();
        return this;
    }

    public LoginPage provideEmailToLogin(String email){
        emailFieldLocator.clear();
        emailFieldLocator.sendKeys(email);
        return this;
    }

    public LoginPage providePasswordToLogin(String password){
        passwordFieldLocator.clear();
        passwordFieldLocator.sendKeys(password);
        return this;
    }

}
