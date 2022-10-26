package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev01 {
    /*

1- http://automationpractice.com/index.php sayfasina gidelim
2- Sign in butonuna basalim
3- Email kutusuna @isareti olmayan bir mail yazip enter’a
4- bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */
    WebDriver driver;

    @Test
    public void method01() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");

        //2- Sign in butonuna basalim
        WebElement signInButton = driver.findElement(By.xpath("//*[@title='Log in to your customer account']"));
        signInButton.click();
        //3- Email kutusuna @isareti olmayan bir mail yazip enter’a
        WebElement emailBox = driver.findElement(By.id("email_create"));
        emailBox.sendKeys("fkurkcu", Keys.ENTER);

        //4- bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        driver.findElement(By.xpath("//*[@id='create_account_error']")).isDisplayed();

    }


}
