package Tekrar.Part6;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C34_WebTables extends TestBaseBeforeAfter {
    //Bir onceki class'daki adrese gidelim
    //Login () methodunu kullanarak sayfaya giris yapalim
    //input olarak verilen satir sayisi ve sutun sayisina sahip
    //cell'deki text'i yazdiralim.
    //Price basligindaki tum numaralari yazdiriniz
    @Test
    public void test01() throws InterruptedException {
        int satir = 3;
        int sutun = 4;

        //Login () methodunu kullanarak sayfaya giris yapalim
        login();

        //cell'deki text'i yazdiralim.
        Thread.sleep(4);
        WebElement cell = driver.findElement(By.xpath("//tbody//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println("Satir ve sutundaki text : " + cell.getText());

        //Price basligindaki tum numaralari yazdiriniz
        List<WebElement> priceBasligi = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement each : priceBasligi) {
            System.out.println(each.getText());

        }
    }


    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
