package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Tekrar03_Faker extends TestBaseBeforeAfter {
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
        WebElement isim = driver.findElement(By.xpath("(//*[@type='text'])[2]"));
        Actions action = new Actions(driver);
        String mail = faker.internet().emailAddress();
        String sifre = faker.internet().password();
        action.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(mail).
                sendKeys(Keys.TAB).
                sendKeys(mail).
                sendKeys(Keys.TAB).
                sendKeys(sifre).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(faker.date().birthday().toString()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
}
