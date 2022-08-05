package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin1Page 
{
	// Step 1
	@FindBy(xpath="//input[@id='userid']")private WebElement UN;
	@FindBy(xpath="//input[@id='password']")private WebElement Pwd;
	@FindBy(xpath="//button[text()='Login ']")private WebElement Loginbtn;
	
	// Step 2      constructor calling
	public KiteLogin1Page(WebDriver driver)
	{
       PageFactory.initElements(driver, this);
     }

	// Step 3  method 
	
	public void inpKiteLogin1PageUserName(String username)
	{
		UN.sendKeys(username);
	}
	
	public void inpKiteLogin1PagePassword(String password)
	{
		Pwd.sendKeys(password);
	}

	public void ClickLogin1PageLoginBtn()
	{
		Loginbtn.click();
	}
}
