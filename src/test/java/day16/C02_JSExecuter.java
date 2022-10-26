package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecuter extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Asagidaki careers butonunu gorunceye kadar js ile scroll yapalim
        WebElement careers = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", careers);

        //Carreers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();", careers);

    }
}
/*
GitHub'a ekle

js.executeScript("arguments[0].scrollIntoView(true);", auto.downloadInvoiceButton);
try {
     driver.findElement(By.linkText("Scans")).click();
  } catch (Exception e) {
     JavascriptExecutor executor = (JavascriptExecutor) driver;
     executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("Scans")));
  }

 */