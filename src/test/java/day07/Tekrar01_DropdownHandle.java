package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tekrar01_DropdownHandle {
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
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {
        //2-Arama kutusunun yanindaki kategori menusundeki
        // kategori sayisinin 45 oldugunu testedin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select option = new Select(ddm);
        System.out.println(option.getOptions().size()); //28
    }

    @Test
    public void test02() {
        //1.Kategori menusunden Books secenegini secin
        driver.findElement(By.xpath("//*[@value='search-alias=stripbooks-intl-ship']")).click();

        //2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        //3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiE = sonucYazisi.getText();
        System.out.println("Sonuc yazisi : " + sonucYazisiE);
        System.out.println("Net sonuc :" + Arrays.stream(sonucYazisiE.split(" ")).collect(Collectors.toList()).get(3));

        //4.Sonucun Java kelimesini icerdigini testedin
        Assert.assertTrue(sonucYazisiE.contains("Java"));
    }

}
