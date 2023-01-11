package Tekrar.Part3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C15_iFrame {
    /*
  ● Bir class olusturun: IframeTest
  ● https://the-internet.herokuapp.com/iframe adresine gidin.
  ● Bir metod olusturun: iframeTest
     ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
     ○ Text Box’a “Merhaba Dunya!” yazin.
     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
       dogrulayin ve konsolda yazdirin
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
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement mesaj = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(mesaj.isEnabled());
        System.out.println(mesaj.getText());

        WebElement iFrame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iFrame);
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.sendKeys("Merhaba Dunya");

        driver.switchTo().defaultContent(); //iframeden cikmak icin
        WebElement yazi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(yazi.isDisplayed());
        System.out.println(yazi.getText());
    }
}
