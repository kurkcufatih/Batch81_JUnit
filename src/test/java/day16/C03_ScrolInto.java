package day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_ScrolInto extends TestBaseBeforeAfter {
    //Yeni bir class olusturun : ScroolInto

    @Test
    public void test01() throws InterruptedException {


        //hotelmycamp anasayfasina gidin
        driver.get("https://www.hotelmycamp.com/");

        //2 farkli test method’u olusturarak actions classi ve
        // Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        WebElement odaCesitleri = driver.findElement(By.xpath("(//*[text()='View Room Details '])[2]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", odaCesitleri);
        jse.executeScript("arguments[0].click();", odaCesitleri);


        //istediginiz oda inceleme sayfasi acildigini test  edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Available Room']")).isDisplayed());
    }
}