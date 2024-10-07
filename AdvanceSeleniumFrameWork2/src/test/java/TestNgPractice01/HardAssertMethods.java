package TestNgPractice01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertMethods {
	public void m1()
	{
		int act = 10;
		int exp = 20;
		Assert.assertEquals(act, exp);
 System.out.println("Assertion Executed");
	}
	
	@Test
	public void m2()
	{
		int act = 10;
		int exp = 20;
		Assert.assertEquals(act, exp, "ExecutionFail");
  System.out.println("Assertion Executed");
	}
	
	@Test
	public void m3()
	{
		int act = 10;
		int exp = 20;
		Assert.assertNotEquals(act,exp, "it is equal");
		System.out.println("Not equal");
}
	
	@Test
	public void m4()
	{
		String s="Hello";
		Assert.assertTrue(s.contains("is"), "False");
		System.out.println("TRUE");
	}
	@Test
	public void m5()
	{
		String s="Hello";
		String ss="Hello";
		Assert.assertTrue(s.equalsIgnoreCase("e"), "False==");
		System.out.println("AssertPass");
		
	}
	@Test
	public void m6()
	{
		int act = 10;
		int exp = 20;
		Assert.assertNotEquals(act,exp, "Not Same");
		System.out.println("Same");
}
	@Test
	public void m7() 
	{
		String s=null;
	Assert.assertNull(s, "not null");
	System.out.println("it is null");
	Assert.fail("i am failing");
	
	}
	
}