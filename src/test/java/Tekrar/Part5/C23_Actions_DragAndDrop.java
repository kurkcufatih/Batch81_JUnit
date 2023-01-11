package Tekrar.Part5;

import Tekrar.Part4.C19_testBase_BeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C23_Actions_DragAndDrop extends C19_testBase_BeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe, dropHere).perform();
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());

    }
}
