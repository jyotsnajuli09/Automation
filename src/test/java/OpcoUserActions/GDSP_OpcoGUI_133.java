package OpcoUserActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GDSP_OpcoGUI_133 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='reports_overview.htm']")
	public static WebElement Reports_Opco;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]/a/img")
	public static WebElement Reports_csv;
	
public static WebDriver driver;
	
	public GDSP_OpcoGUI_133(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException, InterruptedException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		
		 platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
		
	}
	public void reportgeneration(com.aventstack.extentreports.ExtentTest test, String tcid)throws IOException
	{
		Reports_Opco.click();
		Reports_csv.click();
	
		
	
	
	
	
}
}

