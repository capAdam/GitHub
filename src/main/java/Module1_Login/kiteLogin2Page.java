
package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class kiteLogin2Page
{
	@FindBy(xpath="//input[@id='pin']")private WebElement Pin;
	@FindBy(xpath="//button[text()='Continue ']")private WebElement Cntbtn;
	
	public kiteLogin2Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpkiteLogin2PagePin(String Pininfo)
	{
		Pin.sendKeys(Pininfo);
	}

	public void clickLogin2PageCtnbtn()
	{
		Cntbtn.click();
	}
	
//    @FindBy(xpath="//input[@id='pin']")	private WebElement Pin;
//    @FindBy(xpath="//button[text()='Continue ']")private WebElement cntBtn;
//    public kiteLogin2Page(WebDriver driver)
//    {
//    	PageFactory.initElements(driver, this);
//    }
//    
//    public void enterPin()
//	{
//    	Pin.sendKeys("143707");
//	}
//	
//	public void clickOnCntBtn()
//	{
//		cntBtn.click();
//	}

	
}
