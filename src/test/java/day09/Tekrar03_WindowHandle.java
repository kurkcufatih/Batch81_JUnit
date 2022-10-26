package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tekrar03_WindowHandle {
    /*
    1-Yeni bir class olusturun: WindowHandle
    2-Amazon anasayfa adresine gidin.
    3-Sayfa'nin window handle degerini String bir degiskene atayin
    4-Sayfa title'nin "Amazon" icerdigini test edin
    5-Yeni bir tab olusturup, acilan tab'da techproeducation.com adresine gidin
    6-Sayfa title'nin "TECHPROEDUCATION" icerdigini test edin
    7-Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    8-Sayfa title'nin "Walmart" icerdigini test edin
    9-Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
*/
    WebDriver driver;

    @Before
    public void setUp() {
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
    public void test01() {
        driver.get("https://www.amazon.com");
        String amazonWH = driver.getWindowHandle();
        String title = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(title.contains(expectedTitle));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        String techTitle = driver.getTitle();
        String expectedTitle2 = "TECHPROEDUCATION";
        Assert.assertFalse(techTitle.contains(expectedTitle2));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");
        String walmartTitle = driver.getTitle();
        String expectedTitle3 = "Walmart";
        Assert.assertTrue(walmartTitle.contains(expectedTitle3));


        driver.switchTo().window(amazonWH);
        System.out.println(title);
    }
}
