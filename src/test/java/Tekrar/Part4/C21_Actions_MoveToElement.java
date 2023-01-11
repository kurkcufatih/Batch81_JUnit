package Tekrar.Part4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C21_Actions_MoveToElement extends C19_testBase_BeforeAfter {

    @Test
    public void test01() {
        // - Amazon sayfasına gidelim
        // - Account menusundan create a list linkine tıklayalım
        driver.get("https://www.amazon.com");
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        actions.moveToElement(accountList).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}
