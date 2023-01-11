package Tekrar.Part7;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C36_ReadExcel {
    @Test
    public void readExcelTest01() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "C:\\Users\\kurkcu\\Desktop\\ulkeler (1).xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook.
                getSheet("Sayfa1").
                getRow(3).
                getCell(3).
                toString();
        System.out.println(actualData); //Cezayir


    }
}
