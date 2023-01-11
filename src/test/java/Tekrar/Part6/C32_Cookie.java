package Tekrar.Part6;

import Tekrar.Part4.C19_testBase_BeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class C32_Cookie extends C19_testBase_BeforeAfter {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //-tum cookie’leri listeleyin
        Set<Cookie> tumCookies = driver.manage().getCookies();
        System.out.println(tumCookies);
        int sayac = 1;
        for (Cookie each : tumCookies) {
            System.out.println(sayac + " . cookie : " + each);
            System.out.println(sayac + " . name : " + each.getName());
            System.out.println(sayac + " . value : " + each.getValue());
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = tumCookies.size();
        assertTrue(cookieSayisi > 5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : tumCookies) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }

        //5-ismi “en sevdigim cookie” ve degeri
        // “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali cookie");
        driver.manage().addCookie(yeniCookie);
        tumCookies = driver.manage().getCookies();
        sayac = 1;
        for (Cookie each : tumCookies) {
            System.out.println(sayac + " . cookie : " + each);
            System.out.println(sayac + " . name : " + each.getName());
            System.out.println(sayac + " . value : " + each.getValue());
            sayac++;
        }

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookies.contains(yeniCookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookies = driver.manage().getCookies();
        sayac = 1;
        for (Cookie each : tumCookies) {
            System.out.println(sayac + ". cookie : " + each);
            System.out.println(sayac + ". name : " + each.getName());
            System.out.println(sayac + ". value : " + each.getValue());
            sayac++;
        }
        Cookie skin = driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumCookies.contains(skin));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookies=driver.manage().getCookies();
        Assert.assertTrue(tumCookies.isEmpty());


    }

}
