package Tekrar.Part8;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C44_getScreenShot_WebElement extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {

        //amazon sayfasina gidelim
        //Nutella aratalim
        //Arama sonucunun resmini alalim

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).
                sendKeys("Nutella", Keys.ENTER);
        WebElement aramasonucu = driver.
                findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu = aramasonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntusu/NutellaAramaSonucu"+tarih+".jpeg"));

    }
}
