package Tekrar.Part2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertions {
    /*
  - Amazon sayfasina gidelim
  - 3 farkli test methodu olusturalim
  a-URL'nin amazon icerdigini test edelim
  b-Title'in facebook icermedigini test edelim
  c-sol ust kosede amazon logosunun gorundugunu test edelim
  d- Url'nin www.facebook.com oldugunu test edin.

   */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        //a-URL'nin amazon icerdigini test edelim
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        //or
        Assert.assertNotEquals(expectedUrl, actualUrl);
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
        WebElement logo = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());
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

