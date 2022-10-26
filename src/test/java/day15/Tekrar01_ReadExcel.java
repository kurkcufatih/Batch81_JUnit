package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Tekrar01_ReadExcel {
    @Test
    public void test01() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //Excel tablosundaki tum tabloyu konsola yazdirin.
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        String tablo = "";
        for (int i = 0; i<sonSatir ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(j)+", ");
            }
            System.out.println("");
        }
    }
}
