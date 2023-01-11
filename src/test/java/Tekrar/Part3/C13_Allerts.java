package Tekrar.Part3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class C13_Allerts {
      /*
    Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın
    ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
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
    public void tearDown() { driver.close(); }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement actualMessage1 = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(expectedMessage, actualMessage1.getText());
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        WebElement alert2 = driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
        alert2.click();
        driver.switchTo().alert().dismiss();
        WebElement actualMessage2 = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        Assert.assertNotEquals("successfuly", actualMessage2.getText());
    }
    @Test
    public void test03() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        WebElement alert3 = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
        alert3.click();
        driver.switchTo().alert().sendKeys("Fatih");
        driver.switchTo().alert().accept();
        WebElement actualMessage3=driver.findElement(By.xpath("//*[text()='You entered: Fatih']"));
        String expectedData = "Fatih";
        Assert.assertTrue(actualMessage3.getText().contains(expectedData));
    }
}
