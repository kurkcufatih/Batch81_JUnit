package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownHandle {
    /*
    Test01
    1-https://www.amazon.com/ adresine gidin.
    2-Arama kutusunun yanindaki kategori menusundeki
     kategori sayisinin 45 oldugunu testedin

    -Test02
    1.Kategori menusunden Books seceneginisecin
    2.Arama kutusuna Java yazin vearatin
    3.Bulunan sonuc sayisiniyazdirin
    4.Sonucun Java kelimesini icerdigini testedin
*/

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://www.amazon.com/ adresinegidin.
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {

        //2-Arama kutusunun yanindaki kategori menusundeki
        //     kategori sayisinin 45 oldugunu testedin

        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size()); //28

        for (WebElement each : drops) {
            System.out.println(each.getText());
        }

        int dropDownList = drops.size();
        int expectedSayi = 45;
        Assert.assertNotEquals(expectedSayi, dropDownList);
    }

    @Test
    public void test02() {

        // 1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@value='search-alias=stripbooks-intl-ship']"));
        ddm.click();
        //ddm.sendKeys("Books"); bu sekilde de olur

        //    2.Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);

        //    3.Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());

        //    4.Sonucun Java kelimesini icerdigini testedin
        String expectedWord = "Java";
        String actualWord = sonucSayisi.getText();
        Assert.assertTrue(actualWord.contains(expectedWord));
    }
}
