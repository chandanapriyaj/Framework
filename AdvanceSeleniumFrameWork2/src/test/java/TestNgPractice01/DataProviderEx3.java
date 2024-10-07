package TestNgPractice01;

import org.testng.annotations.Test;

public class DataProviderEx3 {
	@Test(dataProvider="dataProviderData")
	public void Organization(String orgName,String phnNum,String mailId) throws Throwable {
	}

}
