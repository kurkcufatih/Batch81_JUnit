package day09;

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

public class C04_WindowHandle {

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
        driver.findElement(By.xpath("//*[text()='Opening a new window']"));

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title = driver.getTitle();
        String word = "The Internet";
        Assert.assertTrue(title.contains(word));

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        /*
        Bir web sitesine girdiginizde bir web elementi tiklandiginizda yeni bir sekme
        ya da pencere acilirsa bu yeni acilan sekmenin handle degerini bulabilmek icin
        driver.getWindowHandles() methodunu  bir arraylist'e atip butun sayfalarin listesine
        ulasabilirsin. Ilk actigim pencere yada sekmede islem yapabilmek icin
        driver.switchTo().window(windowList.get(1)) methodunu kullaniriz.
         */
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Wındow handle degerleri: " + windowList);
        driver.switchTo().window(windowList.get(1)); //Listteki sayfalardan ikinci sayfaya index ile gectik.

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String newWindowTitle = driver.getTitle();
        String expectedTitle = "New Window";
        Assert.assertTrue(newWindowTitle.contains(expectedTitle));
        //2.YOL
        Assert.assertEquals(driver.getTitle(), "New Window");

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals("The Internet", driver.getTitle());

    }
}
