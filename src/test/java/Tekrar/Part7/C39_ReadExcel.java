package Tekrar.Part7;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C39_ReadExcel {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "C:\\Users\\kurkcu\\Desktop\\ulkeler (1).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println(sonSatir); //190

        int expectedLastRow = 191;
        Assert.assertEquals(expectedLastRow, sonSatir + 1);

        int kullanilanSatir = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        // Excel tablosunda kullanılan satır sayısını bu method ile alırız
        System.out.println(kullanilanSatir);

        int expectedKullanilanSatir = 191;
        Assert.assertEquals(expectedKullanilanSatir, kullanilanSatir);

    }
}
