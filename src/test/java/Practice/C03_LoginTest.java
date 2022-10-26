package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginTest {
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

        //Siteye git
        driver.get("https://www.koalaresorthotels.com/");

        //Login'e git
        driver.findElement(By.xpath("//*[@id='navLogon']")).click();

        //Login ekranina girdiginizi 4 farkli web elementi kullanarak dogrulayiniz
        //1
        Assert.assertTrue(driver.getTitle().contains("Log in"));
        //2
        Assert.assertEquals("https://www.koalaresorthotels.com/Account/Logon", driver.getCurrentUrl());
        //3
        driver.findElement(By.xpath("//*[@id='UserName']")).isDisplayed();
        //4
        Assert.assertTrue(driver.getCurrentUrl().contains("Logon"));

        //driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys();
        //driver.findElement(By.xpath("//*[@id='Password']")).sendKeys();
        //driver.findElement(By.xpath("//*[@id='btnSubmit']")).click();
    }
}
