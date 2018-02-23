package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_132 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_events_overview.htm']")
    public static WebElement ManageEvents_Opco;
	
	@FindBy(xpath="//a[@href='manage_outbound_web_services_overview.htm']")
    public static WebElement outboundwsc_ManageEvents;
	
	@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_manageoutboundwebservices;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_132(WebDriver driver)
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
	public void backtotop( com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		 ManageEvents_Opco.click();
		 outboundwsc_ManageEvents.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3050)", "");
		
		
		System.out.println("scrolling successful");
		
		try{
		test.log(Status.INFO,"Scroll down has been done");
		Thread.sleep(3000);
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		BackToTop_manageoutboundwebservices.click();
		Thread.sleep(2000);
		test.log(Status.INFO,"Successfully clicked on Back to top button");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		Thread.sleep(2000);
		test.log(Status.PASS,"Successfully clicked on Back to top button");
		}
		catch(Exception e)
		{
			test.log(Status.INFO,"Not clicked on Back to top button");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			Thread.sleep(2000);
			test.log(Status.FAIL,"Not clicked on Back to top button");
		}
}
}
	

