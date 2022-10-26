package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class GenelTekrarTesti01 extends TestBaseBeforeAfter {


    @Test
    public void test01() {

        //Test01
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
        System.out.println("DropDown Menusunun altbaslik sayisi : " + dropDownMenuList.size());

        //Test02

        //1 dropdown menuden elektronik bölümü seçin
        select.selectByValue("search-alias=electronics-intl-ship");

        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("iphone", Keys.ENTER);

        //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));

        //4 ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrun = driver.findElement(By.xpath("//*[@class='a-size-base-plus a-color-base a-text-normal']"));
        WebElement ucuncuUrun = driver.findElement(By.xpath("//*[@class='a-size-base-plus a-color-base a-text-normal']"));
        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.xpath("(//*[@class='s-image'])[2]")).toRightOf(birinciUrun).toLeftOf(ucuncuUrun));
        ikinciUrun.click();

        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

        //Test03
        //1-yeni bir sekme açarak amazon anasayfaya gidin
        //2-dropdown’dan bebek bölümüne secin
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        //4-sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

        //Test04
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
