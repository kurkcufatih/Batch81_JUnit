package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TekrarC04_FileExists {

    @Test
    public void test1() {
        //Şuanki içinde bulunduğum yolu gösterir
        System.out.println(System.getProperty("A"));//C:\SeleniumBatch81\com.Batch81JUnit

        //Geçerli kullanıcının ana dizinini verir
        System.out.println(System.getProperty("B"));//C:\Users\Lenovo

        String dosyayolu = "C:\\Users\\kurkcu\\Downloads\\selenium methodlar.pdf";
        System.out.println(Files.exists(Paths.get(dosyayolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));

    }
}

