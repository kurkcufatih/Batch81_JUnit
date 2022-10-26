package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class Tekrar03_WebTables extends TestBaseBeforeAfter {
    //login( ) metodun oluşturun ve oturum açın.
    //Username : manager
    //Password : Manager1!
    //table( ) metodu oluşturun
    @Test
    public void test01() throws InterruptedException {
        login();
        int satir = 3;
        int sutun = 4;

        //input olarak verilen satir sayisi ve sutun sayisina sahip
        //cell'deki text'i yazdiralim.
        Thread.sleep(3000);
        WebElement cell = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println("satir ve sutundaki text : " + cell.getText());

        //Price basligindaki tum numaralari yazdiriniz
        List<WebElement> priceBasligi = driver.findElements(By.xpath("//tbody//tr//tf[6]"));
        for (WebElement each : priceBasligi) {
            System.out.println(each.getText());
        }
    }

    private void login() {
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin ve oturum acin

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

}
