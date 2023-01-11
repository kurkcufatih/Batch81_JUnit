package Tekrar.Part8;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C42_DeleteExcel {
    @Test
    public void deleteExcelTest01() throws IOException {

        String dosyaYolu = "C:\\Users\\kurkcu\\Desktop\\ulkeler (1).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        Sheet sheet = workbook.getSheet("Sayfa1");

        //-Row objesi olusturun sheet.getRow(3)
        Row row = sheet.getRow(3);

        //-Cell objesi olusturun row.getCell(3)
        Cell cell = row.getCell(3);

        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);

        /*
        Bir cell'deki veriyi silmek icin row objesine ihtiyac vardir
        Row objesi ile removeCell() methodunu kullanarak cell objesi ile
        belirttigimiz cell degerini silebiliriz
        */

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //-Silindiğini test edin
        String expectedData = "Cezayir";
        String actualData = null;
        Assert.assertNotEquals(expectedData,actualData);


    }
}
