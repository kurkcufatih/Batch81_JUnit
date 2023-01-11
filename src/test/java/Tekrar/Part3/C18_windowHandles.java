package Tekrar.Part3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C18_windowHandles {

//    Tests package’inda yeni bir class olusturun: WindowHandle2
//    https://the-internet.herokuapp.com/windows adresine gidin.
//    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//    Click Here butonuna basın.
//    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//    Sayfadaki textin “New Window” olduğunu doğrulayın.
//    Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.


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
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String text = "Opening a new window";
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains(text));

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowList);
        driver.switchTo().window(windowList.get(1));

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String text2 = "New Window";
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().contains(text2));

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //Bir önceki pencereye geri döndükten sonra
        // sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet", driver.getTitle());

    }
}