package Tekrar.Part6;

import Tekrar.Part4.C19_testBase_BeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C29_FileExists_Upload extends C19_testBase_BeforeAfter {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload ");

        WebElement chooseFile = driver.findElement(By.xpath("//*[@id='file-upload']"));
        String dosyaYolu = "C:\\Users\\kurkcu\\Desktop\\text.txt";
        chooseFile.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
