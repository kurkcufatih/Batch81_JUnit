package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev02 extends TestBaseBeforeAfter {
    @Test
    public void test01() {

        //1-https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //2- video'yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //3-videoyu izlemek icin Play tusuna basin

        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        WebElement playButton = driver.findElement(By.xpath("//*[@aria-label='Play']"));
        playButton.click();
        //4-videoyu calistirdiginizi test edin
        WebElement sesAyarButonu = driver.findElement(By.xpath("//*[@class='ytp-mute-button ytp-button']"));
        Assert.assertTrue(sesAyarButonu.isDisplayed());
    }
}
