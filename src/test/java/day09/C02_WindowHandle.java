package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım
public class C02_WindowHandle {
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
        driver.quit();
    }

    @Test
    public void test01() {

        /*
        Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get()
        methodundan sonra driver'ın window handle değerini string bir değişkene
        atarız. Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra
        tekrar ilk sayfaya dönmemiz istenirse String değişkene atadığımız
        window handle değerleriyle sayfalar arası geçiş yapabiliriz.
        */

        //1- Amazon Sayfasina girelim
        //2- Url'nin amazon içerdiğini test edelim
        driver.get("https://amazon.com");
        String word = "amazon";
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(word));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        String amazonWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();

        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle); //sayfalar arasi gecis icin.
        WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
        textBox.sendKeys("Java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "Java";
        String actualSonuc = aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());
    }
}
