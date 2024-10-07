package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidatingPage {
	
	public  ValidatingPage(WebDriver driver)
	
		{PageFactory.initElements(driver, this);}
	
	
	public void validateCampPage(WebDriver driver,String campName)
  {String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

  Assert.assertEquals(actData, campName);
  System.out.println("CampName is Created");
//	if (actData.contains(campName)) 
//		{System.out.println("campaigns name is created");}
//	else
//		{System.out.println("campaigns name is not created");}
	
	}
		
     public void validateorgPage(WebDriver driver,String OrgName)
   {String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
 	
   Assert.assertEquals(actData, OrgName);
   System.out.println("OrgName is Created");   
// 	if(actData.contains(OrgName))
//        {System.out.println("Organization name is created");}
// 	else
// 	    {System.out.println("Organization name not created");}
  }
     
 	public void validateprdctPage(WebDriver driver,String name)
   
 	 {String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
	
 	   Assert.assertEquals(actData, name);
 	   System.out.println("PrdctName is Created"); 
//	if(actData.contains(name))
//	    {System.out.println("productname name is created");}
//	else
//	    {System.out.println("productname name not created");}
	
		}
}
