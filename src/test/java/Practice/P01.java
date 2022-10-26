package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {
    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // ikinci emojiye tıklayın (hayvan emojisini seçin)
    // tüm hayvan emojilerine tıklayın
    // formu doldurun (dilediğinizi yazabilirsiniz)
    // apply butonuna tıklayın

    @Test
    public void test01() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        driver.findElement(By.xpath("//img[@class='emoji']"));

        // tüm hayvan emojilerine tıklayın
        List<WebElement> animals = driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
        //YOL 1
        /*
        for (WebElement each : animals) {
            each.click();
        }
        */
        //YOL 2
        animals.forEach(t -> t.click());
        driver.switchTo().defaultContent();

        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> form = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        //Bu listi kullanarak her bir webelementi kolayca forma listesinde bulunan
        //webelementlerimize gonderebilecegiz
        List<String> text = new ArrayList<>(Arrays.asList("bu", "listi", "kullanarak", "her", "bir", "webelementi", "kolayca", "form", "listesine", "koymus", "olduk"));

        for (int i = 0; i < form.size(); i++) {
            form.get(i).sendKeys(text.get(i));
        }

        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();


    }
}
