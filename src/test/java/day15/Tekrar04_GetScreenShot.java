package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class Tekrar04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        //Amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https://amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;

        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu"+tarih+".jpeg"));
    }
}
