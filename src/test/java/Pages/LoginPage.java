package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //WebElements POM Page Object Model

    private By emailField = By.cssSelector("[type='email']");
    private By passwordField = By.cssSelector("[type='password']");
    private By loginBtn = By.cssSelector("button[type='submit']");

    //Page Factory
    @FindBy(css = "[type='email']")
    WebElement emailF;
    @FindBy (css ="[type='password']")
    WebElement passwordF;
    @FindBy(css = "button[type='submit']")
    WebElement loginButton;


    //Helper method

    public void provideEmail(String email){

        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password){

        findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn(){

        findElement(loginBtn).click();
    }

    public void login(){
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
    }

    //Methods using Page Factory
    public LoginPage clickSubmitBnt(){
        loginButton.click();
        return  this;
    }

    public LoginPage enterEmail(String email){
        emailF.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password){
        passwordF.sendKeys(password);
        return this;
    }
}
