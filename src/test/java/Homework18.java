import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() {
        provideEmail("agnes.albertusiak@testpro.io");
        providePassword("4Ameryka4aska!");
        clickLoginBtn();
        clickPlayBtn().click();
        Assert.assertTrue(isSongPlaying());

    }

}

