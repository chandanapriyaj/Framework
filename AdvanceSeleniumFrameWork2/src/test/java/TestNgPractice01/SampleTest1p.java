package TestNgPractice01;

import org.testng.annotations.Test;
public class SampleTest1p {

	@Test
	public void createContact()
	{
		System.out.println("contact created");
	}
	
	@Test(dependsOnMethods="contact created")
	public void modifyContact()
	{
		System.out.println("contact modified");
	}
	
	@Test(dependsOnMethods="contact created")
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}
}

//create contact method is independent
//create contact method fail other 2 methods will skip
//create contact method pass other 2 methods will pass
