package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tekrar03_ReadExcel {
    @Test
    public void test01() throws IOException {
        //Belirtilen satirNo ve sutunNo degerlerini
        //parametre olarak alip, o cell'deki datayi
        //konsola yazdiralim.
        int satirNo = 12;
        int sutunNo = 2;
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook.getSheet("Sayfa1").getRow(11).getCell(1).toString();
        String expectedData = "Baku";
        Assert.assertEquals(expectedData, actualData);
    }
}
