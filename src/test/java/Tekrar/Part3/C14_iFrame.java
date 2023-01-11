package Tekrar.Part3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C14_iFrame {
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
        driver.get("https://html.com/tags/iframe/");
        List<WebElement> iFrameList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iFrameList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
    }
}
