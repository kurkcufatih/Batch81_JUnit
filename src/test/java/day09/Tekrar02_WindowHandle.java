package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Tekrar02_WindowHandle {
    //1- Amazon Sayfasina girelim
//2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
//9- Sayfaları Kapatalım

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
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        String currentUrl = driver.getCurrentUrl();
        String expectedWord = "amazon";
        Assert.assertTrue(currentUrl.contains(expectedWord));


        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();
        String url = driver.getTitle();
        String website = "Best Buy";
        Assert.assertTrue(url.contains(website));


        driver.switchTo().window(amazonWindowHandle);
        WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
        textBox.sendKeys("Java", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        List<String> sonucYazisiList = new ArrayList<>(List.of(sonucYazisi.getText().split(" ")));
        System.out.println(sonucYazisiList.get(3));

        driver.switchTo().window(bestbuyWindowHandle);
        WebElement logo = driver.findElement(By.xpath("//*[@class='logo']"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
