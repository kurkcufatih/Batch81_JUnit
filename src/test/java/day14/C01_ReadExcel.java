package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class C01_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //Olusturmus oldugumuz dosyayi sistemde isleme alir.


        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //Workbook objesi ile sisteme fis ile akisa aldigimiz dosyamizla
        //bir excel dosyasi create ettik.


        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");
        //Excel dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz

        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);
        //sayfa1 deki 3'uncu satiri bu sekilde seceriz

        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);
        //sayfa1 deki satir secimi yapildiktan sonra hucre
        //secimi bu sekilde yapilir.
        System.out.println(cell);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData = "Cezayir";
        String actualData = cell.getStringCellValue();
        //veya
        //String actualData = cell.toString();
        Assert.assertEquals(expectedData, actualData);

    /*
    Ara-->dosyaYolu
    Windows Gezgini ile ac-->FileInputStream
    Excel i ac-->Workbook
    Sayfa1 e git-->Sheet
    Satiri bul-->Row
    Sutunu bul-->Cell
     */


    }
}
