import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() {
        //GIVEN
        provideEmail("elliott.nance@testpro.io");
        providePassword("HondaAccord2024$");
        clickSubmit();

        // WHEN
        openPlaylist();
        clickOnDeleteBtn();
        continueToDelete();

        // THEN
        songIsNowPlaying();
    }

        public void openPlaylist() {
            WebElement savedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/playlist/93514']")));
            savedPlaylist.click();
        }

        public void clickOnDeleteBtn() {
            WebElement deleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Delete this playlist']")));
            deleteBtn.click();
        }

        public void continueToDelete() {
            WebElement okToDeleteBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='ok']")));
            okToDeleteBtn.click();
        }
        //THEN
        public void songIsNowPlaying() {
            WebElement songPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        }
    }







