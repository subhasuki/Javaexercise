
 
public class TestNG_Java_file {

 @BeforeClass
 public void setUp() {
 	
   System.out.println("Fast test");
   // code that will be invoked when this test is instantiated
 }
 
 @Test(groups = { "fast" })
 public void aFastTest() {
   System.out.println("Fast test");
 }
 
 @Test(groups = { "slow" })
 public void aSlowTest() {
    System.out.println("Slow test");
 }
 
}