package TestNgPractice01;

import org.testng.annotations.Test;

public class sampleTest01 {

	@Test(priority=1,invocationCount=2)
	public void createContact()
	{
		System.out.println("contact created");
	}
	
	@Test(priority=2)
	public void modifyContact()
	{
		System.out.println("contact modified");
	}
	
	@Test(priority=3)
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}
}
