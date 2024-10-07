package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
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
import ObjectRepository.VtigerLoginPage;

@Listeners(Generic_Utility.ListenersImp.class)
public class CreateOrganizationTest extends BaseClass {
	
@Test(groups= {"smokeTest","regressionTest","sanityTest"})
	public void createOrganizationTest() throws Throwable {
	
	Webdriver_Utility wlib = new Webdriver_Utility();
	File_Utility flib = new File_Utility();
	Java_Utility jlib = new Java_Utility();
	Excel_Utility elib = new Excel_Utility();
		//---from baseclass login to application
	HomePage home = new HomePage(driver);
	home.clickOrgLink();

	CreateOrganizationPage orgpage = new CreateOrganizationPage(driver);//--->object repository
	orgpage.clickOrgPlusSign();

	int ranNum = jlib.getRandomNum();//--->java utility

	String OrgName = elib.getExcelData("Organization", 0, 0)+ ranNum;
	String PhnNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
	String email = elib.getExcelData("Organization", 2, 0);
     System.out.println(OrgName);
     
	orgpage.enterOrgName(OrgName);//--->object repository
	orgpage.enterOrgPhoneNum(PhnNum);
	orgpage.enterOrgEmailId(email);
	orgpage.clickOnSaveButton();
	
	Thread.sleep(1000);
	ValidatingPage  validate = new ValidatingPage (driver);
	validate.validateorgPage(driver, OrgName);
	

	}

}
