package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class Tekrar01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test01() {

        //https://www.automationexercise.com/ adresine gidelim
        driver.get("https://www.automationexercise.com/");

        //product bölümüne girelim
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();

        //ilk ürünü tıklayalım
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@class='fa fa-plus-square']")).click();
    }
}