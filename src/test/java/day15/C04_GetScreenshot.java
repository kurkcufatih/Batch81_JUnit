package day15;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenshot extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {

        //Amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https://www.techproeducation.com");
        TakesScreenshot ts = (TakesScreenshot) driver;

        /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot
        class'indan obje olusturup gecici bir file class'indan
        degiskene TakesScreenShot'dan olusturdugumuz objeden
        getScreenshotAs() methodunu kullanarak gecici bir file olustururum.
        */

        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);

        /*
         LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        tarih =date.format(formatter);

        resmi resmin uzerine degil de yeni bir resim olarak alabilmek icin image ismine tarih ekleyip atadik
        tarih in normal formati dosya isimlendirmeye uygun olmadigi icin tarih yazim formati ile oynayip uygun hale getirdik
        sonra bu sekil bize her zaman lazim olabilir diye TestDataBase imize attik
         */

        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/allPage"+tarih+".jpeg"));

    }
}

