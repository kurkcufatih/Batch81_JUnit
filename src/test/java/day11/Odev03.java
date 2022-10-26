package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev03 extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        //1-amazon gidin
        driver.get("https://www.amazon.com");

        //2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenuLocation = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenuLocation);
        List<WebElement> dropDownMenuList = select.getOptions();

        for (WebElement each : dropDownMenuList) {
            System.out.println(each.getText());
        }
        //3-dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertNotEquals("40", dropDownMenuList.size());
        System.out.println("DropDown Menusunun altbaslik sayisi : "+dropDownMenuList.size());
    }
}