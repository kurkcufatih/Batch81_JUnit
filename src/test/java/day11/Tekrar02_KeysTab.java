package day11;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Tekrar02_KeysTab extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //Cookies kabul et.
        WebElement cookies = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy']"));
        cookies.click();

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //4- Kaydol tusuna basalim
        WebElement bilgiler = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-']"));
        bilgiler.click();
        actions.sendKeys("Fatih").sendKeys(Keys.TAB).sendKeys("Kurkcu").
                sendKeys(Keys.TAB).sendKeys("fkurkcu@st.swps.edu.pl").sendKeys(Keys.TAB).sendKeys("fkurkcu@st.swps.edu.pl").sendKeys(Keys.TAB).sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("15").sendKeys(Keys.TAB).sendKeys("June").sendKeys(Keys.TAB).sendKeys("1994").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
}
