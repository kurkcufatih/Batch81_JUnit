package Tekrar.Part5;

import Tekrar.Part4.C19_testBase_BeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C28_FileExists_Download extends C19_testBase_BeforeAfter {
    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //    test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();

        //    Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\kurkcu\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println(Files.exists(Paths.get(dosyaYolu)));

    }
}
