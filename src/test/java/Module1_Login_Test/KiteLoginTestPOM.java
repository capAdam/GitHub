package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibrayFiles.BaseClass;
import LibrayFiles.UtilityClass;
import Module1_Login.KiteHomePage;
import Module1_Login.KiteLogin1Page;
import Module1_Login.kiteLogin2Page;

public class KiteLoginTestPOM extends BaseClass
{
	KiteLogin1Page Login1;               // Declare Globally
	kiteLogin2Page Login2;
	KiteHomePage home;
	Sheet sh;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException   // it is Non Static Method
	{
		
		// To call Non static Method of other class In Non static method Of another class we simply call the method name
           InitializeBrowser();		 
           // Here we extend the base class thats why we didnt create the object of Non static method to call it here
           // But in case if we didnt Inherit / Extend the base class here & we have to call the Non static method here 
           //then we have to Create an Object of Nonstatic method and by using 
           //Classname.Object name we call Non static method of Base class in Test classs
		  
           // And to call Non static method in Static Method we need to create Object.   
		   
			 Login1=new KiteLogin1Page(driver);                     // Initialize Locally
			 Login2= new kiteLogin2Page(driver);
			 home=new KiteHomePage(driver);
	}
	
	@BeforeMethod
	public void logintoApp() throws EncryptedDocumentException, IOException
	{
		Login1.inpKiteLogin1PageUserName(UtilityClass.getPFData("UN"));
		Login1.inpKiteLogin1PagePassword(UtilityClass.getPFData("PWD"));
		Login1.ClickLogin1PageLoginBtn();
		
		Login2.inpkiteLogin2PagePin(UtilityClass.getPFData("PIN"));
		Login2.clickLogin2PageCtnbtn();
	}
	
	@Test
	public void verifyuserID() throws EncryptedDocumentException, IOException
	{
		// home.VerifyKiteHomePageUserId(sh.getRow(0).getCell(3).getStringCellValue());         we not use this method bcoz we use NG , Ng does not run in POM Class But run In Test Suite
		
		TCID=105;
		String actUserID=home.getKiteHomePageUserID();
		String expUserID=UtilityClass.getTD(0, 3);
		
		//String expUserID=UtilityClass.getTD(0, 2);                                            // we failed here to get ScreenShot
		
		Assert.assertEquals(actUserID, expUserID, "Failed- Both act and exp are diff:");
		
		// Listner Concept--> To get the status of TC that are ran , We get the status whether they pass, failed or skipped etc.
		// Listner contains various Interfaces.ITestResult is one of them.
		// with the help of ITestResult we get the status of TC
	}
	
	@AfterMethod
	public void LogoutfromApp(ITestResult result) throws IOException        // result is object of ITestResult
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.ScreenShotCaptured(driver, TCID);
		}
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}

}
