package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev01 extends TestBaseBeforeAfter {
    @Test
    public void test01() {

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement homf = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(homf).perform();

        //3-Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        //4-Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5-Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6-"Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.click(clickAndHold).keyDown(Keys.SHIFT).perform();

        //7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
        //8- "Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleClick).perform();
    }
}
