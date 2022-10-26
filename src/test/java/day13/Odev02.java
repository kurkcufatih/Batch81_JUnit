package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev02 extends TestBaseBeforeAfter {
    //    Bir metod oluşturun : printData(int row, int column);
//    Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
//    hücredeki(cell) veriyi yazdırmalıdır.
//    Baska bir Test metodu oluşturun: printDataTest( );
//    Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
//    Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
//    yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
    @Test
    public void printDataTest() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
      Thread.sleep(3000);
        int row = 3;
        int column = 5;
        Object expectedData = "USA";
        Object data = printData(row, column);
        System.out.println(data);

        Assert.assertEquals(expectedData, data);
    }

    public Object printData(int row, int column) {
        WebElement dataWE = driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]"));
        Object data = dataWE.getText();
        return data;


    }
}
