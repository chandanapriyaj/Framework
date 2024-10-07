package DDT;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchDataFromJasonFile {

	public static void main(String[] args) throws Throwable {
		//pull back
		//Hello
		File file = new File("./src/test/resources/jason.jason.txt");
		ObjectMapper jasonData = new ObjectMapper();
		JsonNode data = jasonData.readTree(file);
		
		String URL = data.get("url").asText();
		String USERNAME = data.get("username").asText();
		String PASSWORD = data.get("password").asText();
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
	}

}
