package TestNgPractice01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssetEx {
@Test
	public void m1()
	{
		String expData="QSPIDERS";
		String actData="QSPIDERS";
		Assert.assertEquals(expData, actData);
		System.out.println("Gud eveng");
	}
	@Test
	public void m2()
	{
		System.out.println("Hello");
	}
}

