package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {

    /*
    - Amazon sayfasina gidelim
    - 3 farkli test methodu olusturalim
    a-URL'nin amazon icerdigini test edelim
    b-Title'in facebook icermedigini test edelim
    c-sol ust kosede amazon logosunun gorundugunu tet edelim
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //- Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        // her test kisminda driveri tek tek yazmamak adina @beforeclass icinde
        // driver.get'imizi yazdik. Boylece her testten once ilk driver.get()'imiz
        //calismis olacak. Sadece @BeforeClass ta degil, @Before'da da ayni sekilde
        //burada kullanabiliriz.
    }

    @AfterClass
    public static void tearDown() {
        //river.close();
    }

    @Test
    public void test01() {
        //a-URL'nin amazon icerdigini test edelim
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        //veya
        //Assert.assertEquals("buraya mesaj da yazabiliyoruz, url'ler esit degil", expectedUrl, actualUrl);
        //burada hata verecek cunku linkin sonunda / var ama biz .com diye bitirdik
        //normalde .com/ seklinde url yazmamis gerekiyordu. assertEquals bize
        //farkliligida gosterir. Nerede farklilik varsa.
        Assert.assertNotEquals(expectedUrl, actualUrl);
        //burada sonuc pozitif verir hata vermez cunku notequals dedik. Zaten esit
        //olmadigi icin sonuc dogru pozitif yani.
    }

    @Test
    public void test02() {
        //b-Title'in facebook icermedigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test03() {
        //c-sol ust kosede amazon logosunun gorundugunu tet edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test04() {
        //d- Url'nin www.facebook.com oldugunu test edin.
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl, actualUrl);
    }

    /*
    Bu derste Assertion konusunu isledik. Assertion konusunun alt basliklarindan
    1-Assert.assertTrue()
    2-Assert.assertFalse()
    3-Assert.assertEquals()
    4-Assert.assertNotEquals()

    bu basliklari isledik.
     */
}
