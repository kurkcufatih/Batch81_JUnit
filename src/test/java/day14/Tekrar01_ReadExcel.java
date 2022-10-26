package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tekrar01_ReadExcel {
    @Test
    public void test01() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbok = WorkbookFactory.create(fis);

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbok.getSheet("Sayfa1");
        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(1);
        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(1);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        Assert.assertEquals("Cezayir", sheet.getRow(3).getCell(3).toString());
    }
}
