package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Tekrar01_KeyUpKeyDown extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).sendKeys("Samsung ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("71").sendKeys(Keys.ENTER).perform();

        //aramanin gerceklestigini test edin
        driver.findElement(By.xpath("//*[text()='RESULTS']")).isDisplayed();
    }
}
