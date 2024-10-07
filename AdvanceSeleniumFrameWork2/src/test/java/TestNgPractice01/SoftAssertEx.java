package TestNgPractice01;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {
	@Test
	public void m1()
	{
		int act=20;
		int exp=20;
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(act, exp,"failed");
		System.out.println("Assert is pass");
		soft.assertAll();
		
	}

}
