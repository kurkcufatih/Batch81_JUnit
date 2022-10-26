package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RadioButton {

/*
    1-Gerekli yapiyi olusturun ve aşağıdaki görevitamamlayın.
    2-https://www.facebook.com adresine gidin
    3-Cookies’i kabuledin
    4-“Create an Account” button’unabasin
    5-“radio buttons” elementlerini locate edin
    6-Secili degilse cinsiyet butonundan size uygun olanisecin
 */

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
        //driver.close();
    }

    //2-https://www.facebook.com adresine gidin
    @Test
    public void method01() {
        driver.get("https://www.facebook.com");

        //3-Cookies’i kabuledin
        driver.findElement(By.xpath("(//div//button[1])[6]")).click();

        //4-“Create an Account” button’unabasin
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
        //veya
        //driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        //5-“radio buttons” elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("//*[text()='Female']"));
        System.out.println("Female radio butonunun location'i : " + female);
        WebElement male = driver.findElement(RelativeLocator.with(By.xpath("//*[text()='Male']")).toRightOf(female));
        System.out.println("Male radio butonunun location'i : " + male);
        WebElement custom = driver.findElement(RelativeLocator.with(By.xpath("//*[text()='Custom']")).toRightOf(male));
        System.out.println("Cumstom radio butonunun location'i : " + custom);

        //6-Secili degilse cinsiyet butonundan size uygun olanisecin
        male.click();
    }
}

