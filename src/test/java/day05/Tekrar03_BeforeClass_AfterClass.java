package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tekrar03_BeforeClass_AfterClass {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

    @Test
    public void method01() {
        driver.get("https://www.amazon.com");
    }

    @Ignore("Bu testi atlasin")
    @Test
    public void method02() {
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void method03() {
        driver.get("https://www.hepsiburada.com");
    }


}
