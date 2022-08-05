package LibrayFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	// Selenium Related Common Functionalities like Selenium data fetch and capture the Screen shot , excel sheet data
	// For all this concept we use the Utility class
	// The code we write in this class does not require to call in every class thats why we dont inherit it
	// We just require the code of this class in some test classes 
	
	                                          // Description
	
	    //This method is use to get test data from excel sheet
		//Need to provide 2 inputs: 1-rowIndex 2-colIndex
		//@AuthorName: Jarvis

	public static String getTD(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException  
	// We create Static method so it is simple to call in Test Class
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Jarvis\\eclipse-workspace\\Maven11\\Test Data\\Framework.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");		
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		// We does not use the "Value" here we have to use it in Test  class 
		// So , to return the value of this Utility in test class we Have to use Return Method
		
		return value;
		 
	}
	
 //  Declare the code in Utility Class are - Iframe Handle, SC handle , Pop up Handle etc
	
	public static void ScreenShotCaptured(WebDriver driver, int TCID) throws IOException 
	{
//		   LocalDateTime now = LocalDateTime.now();  
//	        System.out.println("Before Formatting: " + now);  
//	        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
//	        String formatDateTime = now.format(format);  
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Jarvis\\eclipse-workspace\\Maven11\\ScreenShot\\"+TCID+".jpg");
		FileHandler.copy(src, dest);
		
		// when we perform execution we get Unique Test Case ID so we give the ScreenShot(SC) of that ID to this SC
		// We mention it in Static method  Parameter  int TCID
	}
	
	public static String getPFData(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Jarvis\\eclipse-workspace\\Maven11\\propertyFile.properties");
		
		// Property class contain Non static method Load.
		// To call load we have to create object of property class.
		
		Properties p=new Properties();
		p.load(file);
		
		// Now the file is open
		// But to read data in file we call getProperty method
		
		String value = p.getProperty(key);
		
		return value;
		
		
		
	}
	
	
}
