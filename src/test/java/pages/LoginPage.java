package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css="[type='email']")
    WebElement emailField;

    @FindBy(css="[type='password']")
    WebElement passwordField;

    @FindBy(css="[type='submit']")
    WebElement clickSubmitBtn;

    public LoginPage provideEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitBtn(){
        clickSubmitBtn.click();
        return this;
    }

    public void login(String email,String password){
        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();

    }


}
