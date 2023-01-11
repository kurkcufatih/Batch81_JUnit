package Tekrar.Part6;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C33_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //login( ) metodun oluşturun ve oturum açın.
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        login();
        table();
    }
    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi : " + sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body : " + body);
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + basliklar.getText());

        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi " + satirList.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t -> System.out.println(t.getText()));

        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4. satir elementleri : " + driver.findElement(By.xpath("//tbody//tr[4]")).getText());
    }
    private void login() {
        String userName = "manager";
        String password = "Manager1!";

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userNameWE = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userNameWE).sendKeys(userName).sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.ENTER);
    }
}
