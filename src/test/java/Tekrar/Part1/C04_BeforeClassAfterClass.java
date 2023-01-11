package Tekrar.Part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
   @AfterClass
   public static void afterClass(){
        driver.close();
   }
   @Test
    public void method01(){ driver.get("https://www.amazon.com");
   }
    @Test
    public void method02(){ driver.get("https://www.techproeducation.com");
    }
    @Test
    public void method03(){ driver.get("https://www.hepsiburada.com");
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
