package Tekrar.Part7;

import com.github.javafaker.File;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C40_ReadExcel {
    @Test
    public void test01() throws IOException {
        //Excel tablosundaki tum tabloyu konsola yazdirin.

        String dosyaYolu = "C:\\Users\\kurkcu\\Desktop\\ulkeler (1).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 1; i < sonSatir; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(j) + ", ");
            }
            System.out.println("");
        }
    }
}
