package Tekrar.Part2;

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

public class C11_DropDownHandle {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @After
    public void tearDown() { driver.close(); }
    @Test
    public void test01() {
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropDownMenu);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText()); //Option 1

        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText()); //Option 2

        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("selected = " + driver.findElement(By.xpath("//*[@selected='selected']")));

        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> list = select.getOptions();
        for (WebElement each : list) {
            System.out.println(each.getText());
        }
        /*
        Please select an option
        Option 1
        Option 2
         */

        list.forEach(t -> System.out.println(t.getText()));
        /*
        Please select an option
        Option 1
        Option 2
         */

        //or


        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println("list.size() = " + list.size()); //list.size() = 3
        int ogeSayisi = 4;
        Assert.assertNotEquals(ogeSayisi, list.size());
    }
}
