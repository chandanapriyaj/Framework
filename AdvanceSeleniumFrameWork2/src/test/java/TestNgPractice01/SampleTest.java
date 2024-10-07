package TestNgPractice01;

import org.testng.annotations.Test;


public class SampleTest {
	
@Test (priority=-1)
public void craeteContact(){
		System.out.println("contact crated");
	}

@Test (priority=1)
	public void modifyContact() {
		System.out.println("contact modified");
	}

@Test (priority=0)
	public void deleteContact() {
	
	System.out.println("contact deleted");
	}
}


