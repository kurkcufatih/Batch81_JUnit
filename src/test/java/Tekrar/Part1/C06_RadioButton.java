package Tekrar.Part1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {

    //1-Gerekli yapiyi olusturun ve aşağıdaki görevitamamlayın.
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
        driver.close();
    }
    @Test
    public void test01() {
        //2-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //3-Cookies’i kabuledin
        driver.findElement(By.xpath("(//div//button[1])[6]")).click();

        //4-“Create an Account” button’unabasin
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();

        //5-“radio buttons” elementlerini locate edin
        WebElement femaleRadioButton = driver.findElement(By.xpath("//*[text()='Female']"));
        WebElement maleRadioButton = driver.findElement(By.xpath("//*[text()='Male']"));
        WebElement customRadioButton = driver.findElement(By.xpath("//*[text()='Custom']"));
        maleRadioButton.click();
    }
}
