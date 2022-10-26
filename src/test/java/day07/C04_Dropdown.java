package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class C04_Dropdown {
    WebDriver driver;

    @Before
    public void setup() {
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
    public void test1() {

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println("Option 1= " + select.getFirstSelectedOption().getText());

        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("Option 2= " + select.getFirstSelectedOption().getText());

        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(driver.findElement(By.xpath("//*[@selected='selected']")).getText());

        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> list = select.getOptions();
        list.forEach(t -> System.out.println(t.getText()));

        //veya
        /*
        for (WebElement each : list) {
            System.out.println(each.getText()); }
        */

        //veya
        //select.getAllSelectedOptions().get(0).getText();

        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int dropDownOgeSayisi = list.size();
        System.out.println(dropDownOgeSayisi);
        int ogesayisi = 4;
        if (dropDownOgeSayisi == ogesayisi) {
            System.out.println("true");
        } else System.out.println("false");

        Assert.assertNotEquals(ogesayisi, dropDownOgeSayisi);

    }
}