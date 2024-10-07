package TestNgPractice01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HardAssertEx2 {
	
	public void login()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		WebElement UserText = driver.findElement(By.name("user_name"));
		Assert.assertTrue(UserText.isDisplayed(), "AssertPass");
		UserText.sendKeys("admin");
		
		WebElement PassWordText = driver.findElement(By.name("user_password"));
		Assert.assertTrue(PassWordText.isDisplayed(), "AssertFailed");
		PassWordText.sendKeys("admin");
		
	}

}
