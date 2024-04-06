package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators

    public void provideEmail(String email){
        findElement(By.cssSelector("input[type='email']")).sendKeys(email);
    }

    public void providePassword(String password){
        findElement(By.cssSelector("input[type='password']")).sendKeys(password);
    }

    public void submitBtn(){
        findElement(By.cssSelector("button[type='submit']")).click();
    }

    public void login(){
        provideEmail("sanjeela.chitrakar@testpro.io");
        providePassword("te$t$tudent1");
        submitBtn();
    }
}
