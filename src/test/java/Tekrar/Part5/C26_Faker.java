package Tekrar.Part5;

import Tekrar.Part4.C19_testBase_BeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C26_Faker extends C19_testBase_BeforeAfter {
    @Test
    public void test01() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy']")).click();

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        //4- Kaydol tusuna basalim
        Faker faker = new Faker();
        WebElement isim = driver.findElement(By.xpath("//*[@name='firstname']"));
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(password).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(faker.date().birthday().toString()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
}
