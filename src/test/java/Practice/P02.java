package Practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 {
        @Test
    public void name() {
        String pom = "pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pom
        )));
    }
}
