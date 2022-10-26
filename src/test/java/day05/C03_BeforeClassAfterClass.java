package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonlari kullaniyorsak,
    olusturacagimiz methodu static yapmamiz gerekiyor.
     */
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    @Ignore("buraya aciklama da yazabiliyoruz")
    /*Çalışmasını istemediğimiz test için
        @Ignore notasyonu kullanılır*/
    public void method1() {
        driver.get("https://amazon.com");
    }

    @Test
    public void method2() {
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void method3() {
        driver.get("https://www.hepsiburada.com");

        /*
        -> BeforeClass - AfterClass --->
        BeforeClass+Test+Test+Test+AfterClass
        çalışıyor sırayla (toplam 5 method çalışıyor).
        Tüm testleri aynı browser'da açtı, s
        on testten sonra browser'ı kapattı.

        -> Before - After --->
            Before+Test+After
            Before+Test+After
            Before+Test+After
            şeklinde (toplam 9 method çalışıyor
         */
    }
}
