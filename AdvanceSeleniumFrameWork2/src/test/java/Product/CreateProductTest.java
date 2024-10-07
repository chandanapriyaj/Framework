package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidatingPage;
import ObjectRepository.VtigerLoginPage;
@Listeners(Generic_Utility.ListenersImp.class)
public class CreateProductTest extends BaseClass{
private String name;

   @Test(groups= {"smokeTest","regressionTest","sanityTest"})
	public void CreateProductTest() throws Throwable {
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		
		HomePage home = new HomePage(driver);
		 home.clickPrdLink();
     //	WebDriver driver=new ChromeDriver();
     //	wlib.windowMaximize(driver);
     //	wlib.pageToLoad(driver);
		 
		CreateProductPage prdtpage = new CreateProductPage(driver);//--->object repository
		prdtpage.clicklookUpImg();
		
		int ranNum = jlib.getRandomNum();//--->java utility
//		
//		File_Utility file = new File_Utility();
//		String URL = file.getKeyAndValuePair("url");
//		String USERNAME = file.getKeyAndValuePair("username");
//		String PASSWORD = file.getKeyAndValuePair("password");
//		
		//driver.get(URL);
//		driver.findElement(By.cssSelector("[name='user_name']")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		//Business Logics
//				VtigerLoginPage login = new VtigerLoginPage(driver);
//				login.loginToVitger(USERNAME, PASSWORD);		
//        driver.findElement(By.linkText("Products")).click();
//		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
//		
		
       	String name = elib.getExcelData("Product", 0, 0)+ ranNum;
			System.out.println(name);
			
			prdtpage.enterPrdName(name);
			prdtpage.clicksaveButton();
			
			Thread.sleep(1000);
			ValidatingPage  validate = new ValidatingPage (driver);
			validate.validateprdctPage(driver, name);
			
//			driver.findElement(By.name("productname")).sendKeys(prdctname);
//			driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click(); //Save button
//			
			
			
//			String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
//			
//			if(actData.contains(prdctname))
//			{
//				System.out.println("productname name is created");
//			}
//			else
//			{
//				System.out.println("productname name not created");
//			}
			
//			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//			driver.findElement(By.linkText("Sign Out")).click();
	}

}
