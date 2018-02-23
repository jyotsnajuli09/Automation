package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_129 {
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
	
	@FindBy(xpath="//a[@href='manage_outbound_web_services_overview.htm']")
	public static WebElement outboundwsc_ManageEvents;
	
	@FindBy(name="formSearchValue2")
	public static WebElement endpointSearchbox_Manageevent;
	
	@FindBy(xpath="//td[input[@src='images/search.png']]/following-sibling::td[3]/input")
	public static WebElement searcicon2_endpointname;
	
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	public static WebElement delete_outboundwsc;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_Manageevents;
	
public static WebDriver driver;
	
	public GDSP_OpcoGUI_129(WebDriver driver)
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
public void deleteoutboundwsc(String endpointname,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	
	{
	
		 Manageevents_Opco.click();
		 outboundwsc_ManageEvents.click();
	
		 endpointSearchbox_Manageevent.sendKeys(endpointname);
		 searcicon2_endpointname.click();
         delete_outboundwsc.click();
        Thread.sleep(2000);
        
 		Actions act=new Actions(driver);
 		Thread.sleep(2000);
 		act.moveToElement(driver.findElement(By.name("ok"))).click().perform();
 		
 		Thread.sleep(2000);
 		 endpointSearchbox_Manageevent.clear();
 		 endpointSearchbox_Manageevent.sendKeys(endpointname);
 		 Thread.sleep(2000);
 		searcicon2_endpointname.click();
 		Thread.sleep(2000);
 		try
		{
			if(usertable_Manageevents.getText().contains("NO DATA FOUND"))
				
				
			{
				test.log(Status.INFO,"outbound wsc deleted successfully");
				Thread.sleep(3000);
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				System.out.println("outbound wsc deleted successfully");
				test.log(Status.PASS,"outbound wsc  deleted successfully");
			}
				
				
		}
		
	catch(Exception e)
		
		{
		test.log(Status.INFO,"outbound wsc is not deleted successfully");
		Thread.sleep(3000);
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		System.out.println("outboundwsc is not deleted successfully");
		test.log(Status.FAIL,"outbound wsc is not deleted successfully");
		
		}
	
	
	
	
	
	
	
	
	
}
}
