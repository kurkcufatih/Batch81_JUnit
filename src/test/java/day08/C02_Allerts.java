package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {
    /*
     Bir web sirtesine girdimizde karsimiza bir uyari mesaji yada bir butona tikladigimizda bir uyari(alert)
     cikabilir. Eger bu uyarıya incele(sag tik-inspect) yaoabiliyorsak bu tur alertt'lere HTML alert denir
     ve istedigimiz locate'i alabiliriz fakat gelen uyari kutusuna mudahale (sag tik-incele) edemiyorsak
     bu tur alert'lere jd alert denir. js alert'lere mudahale edebilmek icin
     - tamam yada ok icin --> driver.switchTo().alert().accept() kullanilir
     - iptal icin --> driver.switchTo().alert().dismiss() kullanilir
     - Alert icindekiğ mesaji almak icin --> driver.switchTo().alert().getText() kullanilir
     - Alert bizde bir metin istiyorsa --> driver.switchTo().alert().sendKeys() kullanilir
     */


      /*
    Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın
        //ve result mesajının  “You successfully clicked an
        // alert” oldugunu test edin.
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj, actualMesaj);

    }

    @Test
    public void tets02() throws InterruptedException {
        //2. butona tıklayın, uyarıdaki Cancel butonuna
        // tıklayın ve result mesajının “successfuly”
        // icermedigini test edin.
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String icermeyenMesaj = "successfuly";
        Assert.assertNotEquals(actualMesaj, icermeyenMesaj);

        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        System.out.println("Alert uzerindeki mesaj : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Fatih");
        driver.switchTo().alert().accept();
        String actualMesaj2 = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "Fatih";
        Assert.assertTrue(actualMesaj2.contains(expectedResult));
    }
}
