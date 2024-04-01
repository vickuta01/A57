import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest{

    @Test
    public void playSong () {

        login("elzat.nurmanbetova@testpro.io", "kochkor123-Q!");

    }

    public void clickPlay() {
        WebElement playNextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextBtn.click();

        playBtn.click();

    }

    public boolean isSongPlays (){
        WebElement soundBar = driver.findElement(By.xpath("img[alt='Sound bars']"));
        return soundBar.isDisplayed();
    }
}
