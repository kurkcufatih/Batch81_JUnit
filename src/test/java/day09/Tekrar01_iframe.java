package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Tekrar01_iframe {
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
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());

        WebElement textBoxiframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(textBoxiframe);
        WebElement textBox = driver.findElement(By.xpath("//*[@class='mce-content-body ']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        driver.switchTo().defaultContent();
        WebElement elemental = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());

    }

}
