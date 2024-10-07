package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_Utility;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.ValidationAndVerification;
import ObjectRepository.VtigerLoginPage;
import ObjectRepository.WindowSwitingToProductPage;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		Webdriver_Utility wlib = new Webdriver_Utility();
		
	WebDriver driver=new ChromeDriver();
	wlib.windowMaximize(driver);
	wlib.pageToLoad(driver);
	
	String URL = flib.getKeyAndValuePair("url");
	String USERNAME = flib.getKeyAndValuePair("username");
	String PASSWORD = flib.getKeyAndValuePair("password");
	
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitger(USERNAME, PASSWORD);
		
		int ranNumber = jlib.getRandomNum();
        HomePage home = new HomePage(driver);
        home.clickPrdLink();
        
        CreateProductPage prdPage = new CreateProductPage(driver);
        prdPage.clicklookUpImg();
        
      String productData = elib.getExcelData("Product", 0, 0)+ranNumber;
	  prdPage.enterPrdName(productData);
	  prdPage.clicksaveButton();
      home.clickMoreLink();
      home.clickCampLink();
      CreateCampaignsPage campPage = new CreateCampaignsPage(driver);
      campPage.clickCampPlusSign();
      String campaignData = elib.getExcelData("Campaign", 0, 0)+ranNumber;
         campPage.enterCampName(campaignData);
         campPage.clickProductPlusSign();
         wlib.windowSwitching(driver, "Products&action");
         WindowSwitingToProductPage campPrdPage = new WindowSwitingToProductPage(driver);
         campPrdPage.enterProductName(productData);
        campPrdPage.searchPrdName();
         campPrdPage.prdNamePresent(driver, productData);
         wlib.windowSwitching(driver, "Campaigns&action");
         campPage.clickOnSaveButton();
    ValidationAndVerification campProdValidation = new ValidationAndVerification(driver);
   campProdValidation.campData(driver, campaignData);
   campProdValidation.productInCamp(driver, productData);
   home.logOutFromApp();
	}}