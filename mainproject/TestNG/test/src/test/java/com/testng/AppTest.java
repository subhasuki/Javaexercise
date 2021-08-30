import org.testng.annotations.*;

public class AppTest {	
    WebDriverTest open1  = new WebDriverTest();
        
    @Test
    public void SampleTest(){
        open1.defineUrl();
        System.out.println("First test case");

    }

    @Test(groups = {"test"})
    public void testcv(){
        System.out.println("First test case");
    }
}
