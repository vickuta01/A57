package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Locators
    By emailField = By.cssSelector("[type='email']");
    By passwordInput = By.cssSelector("[type='password']");
    By pressLoginBtn = By.cssSelector("button[type='submit']");
    public void enterEmail(String email) {
        // WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement emailInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        // WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions
                .elementToBeClickable(passwordInput));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn(){
        // WebElement submitLoginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitLoginBtn  = wait.until(ExpectedConditions
                .elementToBeClickable(pressLoginBtn));
        submitLoginBtn.click();
    }
    public void login(String email,String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }
}
