package Tekrar.Part6;

import Tekrar.Part4.C19_testBase_BeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C30_Senkranizasyon_Waits extends C19_testBase_BeforeAfter {
    @Test
    public void implicitlyWaitTest01() {

        /*
         imlicitlyWait kullandığımız bu method'da sayfadaki
         bütün webelementler için max belirttiğimiz süre
         altında bütün web elementler için bekler

         ====Before methodun icine implicitly wait ekledim=====
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          veya
          2.
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

         */

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 7. It's back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

    }

    @Test
    public void explicitlyWaitTest02() {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsGone.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 7. It's back mesajinin gorundugunu test edin
        WebElement itsBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBack.isDisplayed());
    }
}
