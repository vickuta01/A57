import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        navigateToPage();
        Thread.sleep(2000);
        provideEmail("elzat.nurmanbetova@testpro.io");
        Thread.sleep(2000);
        providePassword("Testpro12345!");
        Thread.sleep(2000);
        clickLoginBtn();
        Thread.sleep(2000);
        searchSong();
        Thread.sleep(2000);
        clickViewAllBtn();
        Thread.sleep(2000);
        clickAddToBtn();
        Thread.sleep(2000);
    }

    public void clickLoginBtn(String songName) {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));

        submit.click();
    }


    public void providePassword(String s) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys();
    }


    public void provideEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys();
    }

    public void navigateToPage() {
        String url = "https://qa.koel.app";
        driver.get(url);
    }



    public void searchSong() {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type='search]"));
        searchField.clear();
        searchField.sendKeys();
    }
    public void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.xpath("//*[@class='songs active']"));
        viewAllBtn.click();
    }
    public void clickAddToBtn(){
        List<WebElement> addToBtn = driver.findElements(By.xpath("//*[@id='extraTabAlbum']"));

    }

    }





