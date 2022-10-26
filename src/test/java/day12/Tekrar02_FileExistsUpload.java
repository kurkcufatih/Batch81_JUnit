package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Tekrar02_FileExistsUpload extends TestBaseBeforeAfter {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFile = driver.findElement(By.xpath("//*[@id='file-upload']"));
        String dosyaYolu = "C:\\Users\\kurkcu\\Downloads\\selenium methodlar.pdf";

        //Yuklemek istediginiz dosyayi secelim.
        chooseFile.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertEquals("File Uploaded!", driver.findElement(By.xpath("//h3")).getText());
    }
}
