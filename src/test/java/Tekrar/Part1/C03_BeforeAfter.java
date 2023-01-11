package Tekrar.Part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver;
    @After
    public void tearDown() {
        driver.close();
    }
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void method01(){
        driver.get("htpps://www.amazon.com");
    }
    @Test
    public void method02(){
        driver.get("https://www.hepsiburada.com");
    }
    @Test
    public void method03(){
        driver.get("https://techproeducation.com");
    }
      /*
        @Before : Önce ; @After : Sonra Demek. @Test kısmında yazdığımız methodlar;
        çalışmaya başlamadan önce @Before yazan method çalışır; sonra kendisi çalışır
        ve en son olarak ta @After da yazılan method çalışır...
        Bu durum her @Test methodunda aynı şekilde çalışır.
        @After ve @Before methodlarının nerde yazıldığının önemi yoktur
         */

}
