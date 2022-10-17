package Practice;

import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	public void creatCutomerTest() {
		System.out.println("step1");
		System.out.println("step2");
		SoftAssert soft =new SoftAssert();
		soft.assertEquals("A", "B");
		System.out.println("step3");
		System.out.println("step4");
		soft.assertAll();
	}
	public void modifyCustomer() {
		System.out.println("----------------");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		
		
	}

}
