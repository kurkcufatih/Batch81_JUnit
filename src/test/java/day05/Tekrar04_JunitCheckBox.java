package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
    a. Verilen web sayfasına gidin.
    https://the-internet.herokuapp.com/checkboxes
    b. Checkbox1 ve checkbox2 elementlerini locate edin.
    c. Checkbox1 seçili değilse onay kutusunu tıklayın
    d. Checkbox2 seçili değilse onay kutusunu tıklayın
   */

public class Tekrar04_JunitCheckBox {
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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
    }
}
