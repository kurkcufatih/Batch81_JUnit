package Tekrar.Part5;

import Tekrar.Part4.C19_testBase_BeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C24_Actions_KeyUp_KeyDown extends C19_testBase_BeforeAfter {
    @Test
    public void test02() {
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Arama kutusuna actions method’larine kullanarak
        //samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox).
                sendKeys("samsung").
                sendKeys(" ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).perform();

        //aramanin gerceklestigini test edin
        WebElement searchResult = driver.findElement(
                By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("searchResult = " + searchResult.getText());
    }
}
