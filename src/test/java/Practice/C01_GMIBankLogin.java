package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_GMIBankLogin {
    public static void main(String[] args) {

        // https://www.gmibank.com/ adresine gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.gmibank.com/");

        // Sign Tıkla
        // Açılan pencerede "Sign in" yazısına tıkla
        driver.findElement(By.xpath("//*[@id='account-menu']")).click();
        driver.findElement(By.xpath("//*[@data-icon='sign-in-alt']")).click();

        // Açılan pencerede Username : "Batch81"  ve Pasword : girin
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Batch81");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Batch81+");
        driver.findElement(By.xpath("(//*[text()='Sign in'])[4]")).click();
        driver.close();
    }
}
