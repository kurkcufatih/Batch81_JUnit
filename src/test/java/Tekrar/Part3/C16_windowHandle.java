package Tekrar.Part3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C16_windowHandle {
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
        //1- Amazon Sayfasina girelim //2- Url'nin amazon içerdiğini test edelim
        driver.get("https://wwww.amazon.com");
        String kelime = "amazon";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(kelime));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim. (https://www.bestbuy.com)
        String amazonWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();

        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
        textBox.sendKeys("Java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath(
                "//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime = "Java";
        String actualResult = aramaSonucu.getText();
        Assert.assertTrue(actualResult.contains(arananKelime));

        //7- Yeniden bestbuy sayfasına gidelim ve Logonun görünürlüğünü test edelim
        driver.switchTo().window(bestBuyWindowHandle);
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='logo'])[1]")).isDisplayed());

    }
}