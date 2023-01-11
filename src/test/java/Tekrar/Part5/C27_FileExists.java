package Tekrar.Part5;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C27_FileExists {
    @Test
    public void test01() {
        //Şuanki içinde bulunduğum yolu gösterir
        System.out.println("Su an icinde bulundugumuz yol = " + System.getProperty("user.dir"));
        //Su an icinde bulundugumuz yol = C:\Users\kurkcu\Desktop\IT\com.Batch81JUnit

        //Geçerli kullanıcının ana dizinini verir
        System.out.println("Gecerli kullanicinin ana dizini = " + System.getProperty("user.home"));
        //Gecerli kullanicinin ana dizini = C:\Users\kurkcu

        String dosyaYolu = "C:\\Users\\kurkcu\\Desktop\\text.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu))); //true
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        /*
        Bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı doğrulamak için
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız
         */
    }

}
