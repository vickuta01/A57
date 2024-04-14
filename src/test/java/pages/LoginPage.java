package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePages{
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    //webElements
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private  By loginBtn = By.cssSelector("button[type='submit']");

    //using page factory
    @FindBy(css = "input[type='email']")
    WebElement emailFieldLocator;
    @FindBy(css = "input[type='password']")
    WebElement passwordFieldLocator;
    @FindBy(css = "button[type='submit']")
    WebElement loginBtnLocator;

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
    //Method using Page factory
    public LoginPage clickSubmitButton(){
        loginBtnLocator.click();
        return this;
    }
    public LoginPage provideEmailLogin(String email){
        emailFieldLocator.clear();
        emailFieldLocator.sendKeys(email);
        return this;
    }
    public LoginPage providePasswordLogin(String password){
        passwordFieldLocator.clear();
        passwordFieldLocator.sendKeys(password);
        return this;
    }
}
