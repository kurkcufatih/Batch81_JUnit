package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tekrar05_ReadExcel {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //-sayfa 2'ye gidip satir sayisinin 15, kullanilan satir sayisinin ise 4 oldugunu test edin
        int sonSatir = workbook.getSheet("Sayfa2").getLastRowNum();
        int expectedLastRow = 15;
        Assert.assertEquals(expectedLastRow, sonSatir + 1);

        int amountOfUsedRow = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedUsedRowAmount = 4;
        Assert.assertEquals(expectedUsedRowAmount, amountOfUsedRow);
    }
}
