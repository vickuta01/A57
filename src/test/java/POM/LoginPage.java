package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    //constructor
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    //Locators
  /*  By emailField= By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn=By.cssSelector("button[type='submit']");
    By login =By.cssSelector("button[type='submit']");// Trying to use login instead of submit

    //........................//
    //.....Page Factory.......//
    @FindBy(css = "input[type='email']")
    WebElement emailFieldLocator;
    @FindBy(css = "input[type='password']")
    WebElement passwordFieldLocator;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtnLocator;
    @FindBy(css = "button[type='submit']")
    WebElement loginBtnLocator;         /// Added to match with my homework22


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
    //public void clickSubmitBtn(){
        public void clickSubmitBtn(){
        findElement(submitBtn).click();


    }


    //Methods using Page Factory Elements

    public LoginPage clickOnLoginBtnLocator(){
        loginBtnLocator.click();
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




    public void login() {
        WebElement loginBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click(); //To fix error until I figure out the problem of mismatching the call on homework-22(loginpage.login())
    }
    */

    //////////////////////////
    /////////////////////////
    //from bala's homework-23
    //Locators
    private By emailField= By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submitBtn=By.cssSelector("button[type='submit']");
    By login =By.cssSelector("button[type='submit']");// Trying to use login instead of submit

    //........................//
    //.....Page Factory.......//
    @FindBy(css = "input[type='email']")
    private WebElement emailFieldLocator;
    @FindBy(css = "input[type='password']")
    private WebElement passwordFieldLocator;

    @FindBy(css = "button[type='submit']")
    private WebElement submitBtnLocator;
    @FindBy(css = "button[type='submit']")
    private WebElement loginBtnLocator;         /// Added to match with my homework22


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
    //public void clickSubmitBtn(){
    public void clickSubmitBtn(){
        findElement(submitBtn).click();


    }


    //Methods using Page Factory Elements

    public LoginPage clickOnLoginBtnLocator(){
        loginBtnLocator.click();
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




    public void login() {
        WebElement loginBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click(); //To fix error until I figure out the problem of mismatching the call on homework-22(loginpage.login())
    }


}
