package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Locators
    @FindBy(css ="[type='email']" )
    WebElement emailInput;
    //By emailField = By.cssSelector("[type='email']");
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    //By passwordInput = By.cssSelector("[type='password']");
    @FindBy(css ="button[type='submit']" )
    WebElement submitLoginBtn;
    By pressLoginBtn = By.cssSelector("button[type='submit']");
    /*public void enterEmail(String email) {
        // WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        //WebElement emailInput = wait.until(ExpectedConditions
        //        .visibilityOfElementLocated(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }*/
    public LoginPage enterEmail(String email) {
        // WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        //WebElement emailInput = wait.until(ExpectedConditions
        //        .visibilityOfElementLocated(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    /*public void enterPassword(String password){
        /// WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        //WebElement passwordField = wait.until(ExpectedConditions
        //        .elementToBeClickable(passwordInput));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }*/
    public LoginPage enterPassword(String password){
        /// WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        //WebElement passwordField = wait.until(ExpectedConditions
        //        .elementToBeClickable(passwordInput));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    /*public void clickLoginBtn(){
        /// WebElement submitLoginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        //WebElement submitLoginBtn  = wait.until(ExpectedConditions
        //        .elementToBeClickable(pressLoginBtn));
        submitLoginBtn.click();
    }*/
    public LoginPage clickLoginBtn(){
        submitLoginBtn.click();
        return this;
    }
    public void login(String email,String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }
    public boolean isSubmitLoginBtnDisplayed(){
        return driver.findElement(pressLoginBtn).isDisplayed();
    }
}
