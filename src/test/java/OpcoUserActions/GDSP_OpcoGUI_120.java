package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_120 {
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
	
	@FindBy(xpath="//td[input[@src='images/search.png']]/following-sibling::td[3]/input[@src='images/search.png']")
	public static WebElement Searchicon_eventfilter;
	
	@FindBy(xpath="//img[@src='images/delete.png']")
	public static WebElement deleteimageicon_Manageevent;
	

	
	
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_Manageevents;
	
public static WebDriver driver;
	
	public GDSP_OpcoGUI_120(WebDriver driver)
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
	public void deletenotificationevent(String eventname,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		
		Manageevents_Opco.click();
		eventSearchbox_Manageevent.sendKeys(eventname);
		Searchicon_eventfilter.click();
		deleteimageicon_Manageevent.click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("submit"))).click().perform();
		Thread.sleep(2000);
		
		eventSearchbox_Manageevent.clear();
		eventSearchbox_Manageevent.sendKeys(eventname);
		Searchicon_eventfilter.click();
		try
		{
			if(usertable_Manageevents.getText().contains("NO DATA FOUND"))
				
				
			{
				test.log(Status.INFO,"event deleted successfully");
				Thread.sleep(3000);
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				System.out.println("event deleted successfully");
				test.log(Status.PASS,"event deleted successfully");
			}
				
				
		}
		
	catch(Exception e)
		
		{
		test.log(Status.INFO,"event is not deleted successfully");
		Thread.sleep(3000);
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		System.out.println("event is not deleted successfully");
		test.log(Status.FAIL,"event is not deleted successfully");
		
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}


