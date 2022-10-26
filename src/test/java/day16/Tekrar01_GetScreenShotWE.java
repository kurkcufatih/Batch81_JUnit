package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.sql.Driver;

public class Tekrar01_GetScreenShotWE extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //Nutella aratalim
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        //Arama sonucunun resmini alalim

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmiAmazon = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmiAmazon, new File("target/ekranGoruntusu.jpeg"));
    }
}

