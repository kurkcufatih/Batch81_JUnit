package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Tekrar03_moveToElement extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // - Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        WebElement helloSignIn = driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        Actions action = new Actions(driver);
        action.moveToElement(helloSignIn).perform();
        // - Account menusundan create a list linkine tıklayalım
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}