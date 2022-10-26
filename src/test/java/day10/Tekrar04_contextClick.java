package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Tekrar04_contextClick extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan bölümün uzerinde sag click yapalim
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        //Tamam diyerek alert’i kapatalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions action = new Actions(driver);
        action.contextClick(cizgiliAlan).perform();
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.findElement(By.xpath("//*[@class='example']")).click();
        Assert.assertEquals("Elemental Selenium", driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());
    }
}
