package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Tekrar02_Webtables extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //login( ) metodun oluşturun ve oturum açın.
        //Username : manager
        //Password : Manager1!
        //table( ) metodu oluşturun
        login();
        table();
    }

    private void login() {
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin ve oturum acin

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

    private void table() {

        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun sayisi : "+sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar=driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : "+basliklar.getText());
        WebElement body=driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum body : "+body.getText());

        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement>satirList=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi : "+satirList.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t-> System.out.println(t.getText()));

        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("Tablodaki 4. satir : "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());


    }
}
   