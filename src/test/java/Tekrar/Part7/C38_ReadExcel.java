package Tekrar.Part7;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C38_ReadExcel {

    //-Turkce baskentler sutununu yazdiralim

    @Test
    public void test01() throws IOException {
        String dosyaYolu = "C:\\Users\\kurkcu\\Desktop\\ulkeler (1).xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        //getLastRowNum() methodu bize excel sayfasindaki tum  deger girilmis satir sayisini verir.

        System.out.println("Var olan satur sayisi : " + sonSatir);
        //Var olan satur sayisi : 190

        String turkceBasketler = "";
        for (int i = 0; i <= sonSatir; i++) {
            turkceBasketler = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBasketler);
        }

    }
}
