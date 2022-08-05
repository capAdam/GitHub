package LibrayFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	// Base Class is our SUPER CLASS , we can Inherit it by EXTENDS Keyword in Test Class
	// If we have multiple test class then we don't have to run the same code in all class
	// we simply create the method and declare the code in it and inherit it in other classes By Extend Keyword
	// The code write in this class is  necessary to run in multiple Test Class Thats why Extend it , & mention it as Base Class 
	
	public WebDriver driver;
	
	public void InitializeBrowser() throws IOException            // Non static Method 
	{
		// We just open the Browser here and inherit it in multiple Test Class , So  multiple Test Class can Access it.
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jarvis\\eclipse-workspace\\Maven11\\Browser\\chromedriver.exe");
			
		 driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(UtilityClass.getPFData("URL"));
		
	}
	

}
