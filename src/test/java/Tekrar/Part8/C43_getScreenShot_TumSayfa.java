package Tekrar.Part8;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C43_getScreenShot_TumSayfa extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;

         /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot
        class'indan obje olusturup gecici bir file class'indan
        degiskene TakesScreenShot'dan olusturdugumuz objeden
        getScreenshotAs() methodunu kullanarak gecici bir file olustururum.
        */
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/tumSayfa"+tarih+".jpeg"));

    }
}
