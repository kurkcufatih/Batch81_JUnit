package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev03 extends TestBaseBeforeAfter {
//    Bir Class olusturun D19_WebtablesHomework

//“https://demoqa.com/webtables” sayfasina gidin
//    Headers da bulunan department isimlerini yazdirin
//    sutunun basligini yazdirin
//    Tablodaki tum datalari yazdirin
//    Tabloda kac cell (data) oldugunu yazdirin
//    Tablodaki satir sayisini yazdirin
//    Tablodaki sutun sayisini yazdirin
//    Tablodaki 3.kolonu yazdirin
//    Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
//    Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin

    @Test
    public void test01() {
        //“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //Headers da bulunan department isimlerini yazdirin
        System.out.println("Basliklar : " + driver.findElement(By.xpath("//div[@class='rt-thead -header']")).getText());

        //Sutunun basligini yazdirin
        System.out.println("Sutunun basligi : " + driver.findElement(By.xpath("//*[text()='First Name']")).getText());

        //Tablodaki tum datalari yazdirin
        System.out.println("Tablodaki Tum datalar : " + driver.findElement(By.xpath("//*[@class='rt-tbody']")).getText());

        //Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> hucreSayisi = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("Hucre Sayisi : " + hucreSayisi.size());

        //Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("Satir Sayisi : " + sutunSayisi.size());

        //Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Satir Sayisi : " + satirSayisi.size());

        //Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuColumn = new ArrayList<>(driver.findElements(By.xpath("//div[@class='rt-td' or role='gridcell'][3]")));
        ucuncuColumn.forEach(t -> System.out.println("3. kolon : " + t.getText()));

        //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        List<WebElement> firstNameList = driver.findElements(By.xpath("//div[@class='rt-td' or role='gridcell'][1]"));
        for (int i = 0; i < firstNameList.size(); i++) {
            if (firstNameList.get(i).getText().equals("Kierra")) {
                System.out.println(driver.findElement(By.xpath("(//div[@class='rt-td' or role='gridcell'][5])[" + (i + 1) + "]")).getText());
            }
        }
    }

    private void date(int x, int y) {
        x=1;
        y=3;
        WebElement veri = driver.findElement(By.xpath("(//div[@class='rt-td' or role='gridcell'][" + x + "])[" + y + "]"));
        System.out.println("İstenilen Veri :"+veri.getText());

    }

}


