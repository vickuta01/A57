package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By emailFieldLocator = By.cssSelector("input[type='email']");
    private By passwordFieldLocator = By.cssSelector("input[type='password']");
    private By sunmitBtnLocator = By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        WebElement emailField = findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password){
        WebElement passwordField = findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitBth(){
        findElement(sunmitBtnLocator).click();
    }

    public void login(String email,String password){
        provideEmail(email);
        providePassword(password);
        clickSubmitBth();

    }


}
