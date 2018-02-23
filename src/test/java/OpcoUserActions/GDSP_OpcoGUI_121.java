package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_121 {


	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_events_overview.htm']")
	public static WebElement Manageevents_Opco;
	

	
	@FindBy(name="formSearchValue2")
	public static WebElement eventSearchbox_Manageevent;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_Manageevents;
	@FindBy(xpath="//td[input[@src='images/search.png']]/following-sibling::td[3]/input[@src='images/search.png']")
	public static WebElement Searchicon_eventfilter;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_121(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
		
	}
	public void eventfilter(String eventname, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		Manageevents_Opco.click();
	
		eventSearchbox_Manageevent.sendKeys( eventname);
		Thread.sleep(2000);
		Searchicon_eventfilter.click();
try
{
		if((usertable_Manageevents.getText()).contains( eventname))
		{
			
			test.log(Status.PASS, "event is filtered successfully");
			//JavascriptExecutor jse = (JavascriptExecutor) driver;
			//jse.executeScript("window.scrollBy(0,2650)", "");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
			System.out.println("event is filtered successfully");
		}
}
catch(Exception e)
		
		{	
			test.log(Status.INFO, "event is not filtered successfully");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("event is not filtered successfully");
			test.log(Status.FAIL, "event is not filtered successfully");
		}

		
		
		
		
		
	}
	
}

