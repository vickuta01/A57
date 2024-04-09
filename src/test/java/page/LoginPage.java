package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


//Locators Using Selenium Page Factory

    @FindBy(css="[type='email']")
    WebElement emailTxtField;

    @FindBy(css="[type='password']")
    WebElement passwordTxtField;

    @FindBy(css="[type='submit']")
    WebElement clickSubmitBtn;



   //Locators BY
  /*  public void provideEmail(String email){
        WebElement emailField = findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }



    public void providePassword(String password){
        WebElement passwordField = findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitBth(){
        findElement(By.cssSelector("button[type='submit']")).click();
    }*/

    public void login(String email,String password){
        provideEmailLogin(email);
        providePasswordLogin(password);
        clickSubmitBtn();

    }

    //Helper Methods Using Page Factory
    public LoginPage provideEmailLogin(String email){
        emailTxtField.sendKeys(email);
        return this;
    }
    public LoginPage providePasswordLogin(String password){
    passwordTxtField.sendKeys(password);
    return this;
    }
    public LoginPage clickSubmitBtn(){
    clickSubmitBtn.click();
    return this;
    }


}
