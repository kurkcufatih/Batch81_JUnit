package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest01() throws IOException {
        //Belirtilen satirNo ve sutunNo degerlerini
        //parametre olarak alip, o cell'deki datayi
        //konsola yazdiralim.
        int satirNo = 12;
        int sutunNo = 2;

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook.getSheet("Sayfa1").
                getRow(satirNo-1).getCell(sutunNo-1).toString();
        System.out.println(actualData);
        //SatirNo ve SutunNo'dan sonra -1 yapmamizin sebebi index'in 0 dan baslamasi.
        //Yani bizden istenen satira ulasabilmek icin bir eksigini aliyoruz.

        //Sonra sonucun konsolda yazanla ayni oldugunu dogrulayalim.
        String expectedData = "Baku";
        Assert.assertEquals(expectedData, actualData);
    }
}
