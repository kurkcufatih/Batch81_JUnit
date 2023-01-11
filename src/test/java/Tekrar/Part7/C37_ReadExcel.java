package Tekrar.Part7;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C37_ReadExcel {
    @Test
    public void test01() throws IOException {
        //Belirtilen satirNo ve sutunNo degerlerini
        //parametre olarak alip, o cell'deki datayi
        //konsola yazdiralim.

        int satirNo = 12;
        int sutunNo = 2;

        String dosyaYolu = "C:\\Users\\kurkcu\\Desktop\\ulkeler (1).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook.getSheet("Sayfa1").getRow(satirNo - 1).getCell(sutunNo - 1).toString();
        System.out.println(actualData);

        //SatirNo ve SutunNo'dan sonra -1 yapmamizin sebebi index'in 0 dan baslamasi.
        //Yani bizden istenen satira ulasabilmek icin bir eksigini aliyoruz.

        Assert.assertEquals("Baku", actualData); //Baku
    }
}
