package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class Tekrar01_Cookie extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //-tum cookie’leri listeleyin
        Set<Cookie> tumCookies = driver.manage().getCookies();
        System.out.println(tumCookies);
        int sayac = 1;
        for (Cookie each : tumCookies) {
            System.out.println(sayac + ". cookie " + each);
            System.out.println(sayac + ". cookie " + each.getName());
            System.out.println(sayac + ". cookie " + each.getValue());
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int actualCookieNumber = tumCookies.size();
        Assert.assertTrue(actualCookieNumber > 5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each : tumCookies) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("enSevdigimCookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        sayac = 1;
        for (Cookie each : tumCookies) {
            System.out.println(sayac + ". cookie " + each);
            System.out.println(sayac + ". cookie " + each.getName());
            System.out.println(sayac + ". cookie " + each.getValue());
            sayac++;
        }

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookies.contains(yeniCookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookies = driver.manage().getCookies();
        sayac = 1;
        for (Cookie each : tumCookies) {
            System.out.println(sayac + ". cookie " + each);
            System.out.println(sayac + ". cookie " + each.getName());
            System.out.println(sayac + ". cookie " + each.getValue());
            sayac++;
        }
        Cookie isim = driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumCookies.contains(isim));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookies = driver.manage().getCookies();
        Assert.assertTrue(tumCookies.isEmpty());
    }
}
