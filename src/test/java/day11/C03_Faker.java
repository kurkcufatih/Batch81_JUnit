package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy']")).click();

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //4- Kaydol tusuna basalim
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions action = new Actions(driver);
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        /*
        Faker class'ini kullanma amacimiz random veriler kullanir
        ve isimizi kolaylastirir.
        Faker class'i kullanirken faker class'ini kullanmak icin
        mvnreposirotry.com adresinden java faker kutuphanesini aratir
        ve en cok kullanilani pom.xml dosyamiza ekleriz. Ve faker class'indan
        bir obje olusturup ;
        1. Email icin faker.internet.emailaddress() methodunu seceriz.
        2. Password icin de ayni internet methodunu kullaniriz.
        3. Isim ve soyisimler icin faker.name() methodu ile firstname ve lastname
        methodunu kullaniriz.
       */
        action.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(password).
                sendKeys(Keys.TAB).sendKeys(faker.date().birthday().toString()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
    }
}
