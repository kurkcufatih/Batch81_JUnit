package Practice;

import org.junit.*;

public class C02_JUnit {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
        //Her classta ilk calisir. 1 defa calisir.
    }

    @Before
    public void before() {
        System.out.println("Before");
        //Her testten once calisir.
    }

    @After
    public void after() {
        System.out.println("After");
        //Her testten sonra calisir
    }

    @Test
    public void test01() {
        System.out.println("test 01");
    }

    @Test
    public void test02() {
        System.out.println("test 02");

    }

    @Test
    public void test03() {
        System.out.println("test 03");

    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
        //Her class'imizin sonunda 1 defa calisir.

    }
}
