package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
	@FindBy(xpath="//span[@class='user-id']")private WebElement UserId;

	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getKiteHomePageUserID()
	{
		String actUserID = UserId.getText();
		return actUserID;                          // to return value from 1 method to other method we use return type
	}
		
	
	
	
//	public void VerifyKiteHomePageUserId(String ExpUserId)
//	{
//		String actUserId = UserId.getText();
//		
//		
//		if(actUserId.equals(ExpUserId))
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
	}
	

