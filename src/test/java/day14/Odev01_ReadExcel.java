package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Odev01_ReadExcel {
    @Test
    public void test01() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);

        //-1.satirdaki 2.hucreye gidelim ve yazdiralim
        String firstRowSecondCell = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(firstRowSecondCell);
        System.out.println("=====================");

        //-2.satir 4.cell’in afganistan’in baskenti oldugunu testedelim
        String actualCellValue = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expectedCellValue = "Kabil";
        Assert.assertTrue(expectedCellValue.equals(actualCellValue));

        //-Satir sayisini bulalim
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());

        //-Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

        //-Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        int rowCount = workbook.getSheet("Sayfa1").getLastRowNum();
        Sheet sheet = workbook.getSheet("Sayfa1");

        Map<String, String> mapList = new HashMap<>();
        for (int i = 0; i < rowCount; i++) {

            Row row = sheet.getRow(i);
            Cell keyCell = row.getCell(0);
            String key = keyCell.getStringCellValue();

            Cell valueCell = row.getCell(1);
            String value = valueCell.getStringCellValue();

            mapList.put(key, value);
        }
        Set<Map.Entry<String, String>> entryList = mapList.entrySet();
        entryList.forEach(System.out::println);
    }
}
