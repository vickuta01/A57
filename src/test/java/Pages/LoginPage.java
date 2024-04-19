package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //WebElements

    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By loginBtn = By.cssSelector("button[type='submit']");
    private  final By provideEmail = By.cssSelector("[type='email']");
    private  final By providePassword = By.cssSelector("[type='password']");
    private  final By clickLoginBtn = By.cssSelector("button[type='submit']");



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
        provideEmail("nemanja.sijacic@testpro.io");
        providePassword("Vojvodina.021");
        clickLoginBtn();
    }


}
