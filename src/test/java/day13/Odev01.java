package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Odev01 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {

//    Bir class oluşturun : D18_WebTables
//    login( ) metodun oluşturun ve oturum açın.
//    https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        login();
//    Username : manager  ○ Password : Manager1!
        table();
//    table( ) metodu oluşturun
//    Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
//    Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
//    printRows( ) metodu oluşturun //tr
//    table body’sinde bulunan toplam satir(row) sayısını bulun.
//    Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
//            4.satirdaki(row) elementleri konsolda yazdırın.
//    printCells( ) metodu oluşturun //td
        printCells();
//    table body’sinde bulunan toplam hücre(cell) sayısını bulun.
//    Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
//    printColumns( ) metodu oluşturun
        printColumns();
//    table body’sinde bulunan toplam sutun(column) sayısını bulun.
//    Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
//            5.column daki elementleri konsolda yazdırın.

    }

    private void printColumns() {
        //    table body’sinde bulunan toplam sutun(column) sayısını bulun.
        WebElement sutunlar = driver.findElement(By.xpath("//thead//tr//th"));
        System.out.println("sutun sayisi : " + sutunlar.getSize());
        //    Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        System.out.println("sutunlar : " + sutunlar.getText());
        //            5.column daki elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//thead//tr//th[5]")).getText());
    }

    private void printCells() {
        WebElement hucreSayisi = driver.findElement(By.xpath("//tbody//tr//td"));
        System.out.println("Hucre sayisi: " + hucreSayisi.getSize());
    }

    private void table() throws InterruptedException {
        //    Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        Thread.sleep(3000);
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//tbody//tr//th"));
        System.out.println("sutun sayisi : " + sutunSayisi.size());

        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body : " + tumBody.getText());

        //    Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + basliklar.getText());

        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi" + satirSayisi.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : satirSayisi) {
            System.out.println(each.getText());
        }
        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4. satirdaki element : " + driver.findElement(By.xpath("//tbody//tr[4]")).getText());

        //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        List<WebElement> hucreSayisi = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("Hucre Sayisi : "+hucreSayisi.size());
        for (WebElement each:hucreSayisi) {
            System.out.println("Hucre Degerleri : "+each.getText());
        }
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();


    }
}