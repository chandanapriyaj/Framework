package Campaign;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidatingPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@Listeners(Generic_Utility.ListenersImp.class)
public class CreateCampaignsTest extends BaseClass {
	
@Test(retryAnalyzer=Generic_Utility.RetryImp.class)
	public void createOrganizationTest() throws Throwable {
		
		Webdriver_Utility wlib = new Webdriver_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
			//---from baseclass login to application
		
		HomePage home = new HomePage(driver);
		home.naviagteCamp(driver);

		CreateCampaignsPage camppage = new CreateCampaignsPage(driver);//--->object repository
		camppage.clickCampPlusSign();
		
        //Assert.fail("im failing the script");
		int ranNum = jlib.getRandomNum();//--->java utility

		String campName = elib.getExcelData("Campaigns", 0, 0)+ ranNum;
	    System.out.println(campName);
	     
	    camppage.enterCampName(campName);//--->object repository
	    camppage.clickOnSaveButton();
		
		Thread.sleep(2000);
		ValidatingPage  validate = new ValidatingPage (driver);
		validate.validateCampPage(driver, campName);
		

		}

	}