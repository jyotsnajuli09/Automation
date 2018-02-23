package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_142 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_apn_overview.htm']")

	public static WebElement Network_Opco;
	
	@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_configureNetworktrace;
	@FindBy(xpath="//td[1][@id='leftcolsmaller']")
	public static WebElement configureNetworktrace_network;
	
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_142(WebDriver driver)
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

	public void backtotop( com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Network_Opco.click();
		Thread.sleep(2000);
		
		try{
			if(configureNetworktrace_network.isDisplayed())
			{
				
			
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3050)", "");
		
		
		System.out.println("scrolling successful");
		
		String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath1);	
		
		test.log(Status.INFO,"Scroll down has been done");
		Thread.sleep(3000);
		BackToTop_configureNetworktrace.click();
		Thread.sleep(2000);
		test.log(Status.INFO,"Successfully clicked on Back to top button");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		test.log(Status.PASS,"Successfully reached on the top button");
		Thread.sleep(2000);
			}
		}
	catch(Exception e)
	{
		test.log(Status.INFO,"it cant be clicked on Back to top button");
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		test.log(Status.FAIL,"it cant be clicked on Back to top button");	
	}
	
}

}
