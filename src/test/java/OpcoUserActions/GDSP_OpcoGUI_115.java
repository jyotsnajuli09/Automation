package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_115 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_vpn_groups_overview.htm']")
	public static WebElement ManageVPNs_Opco;
	
	@FindBy(xpath="//a[@href='manage_vpn_barring_overview.htm']")
	public static WebElement Calllistconfiguration_ManageVPNs;
	
	@FindBy(name="formSearchValue")
	public static WebElement barrierSeachbox_Calllistconfiguration;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_ManageVPNs;
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement Searchicon_vpnbarringname;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_115(WebDriver driver)
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
	public void vpnbarringseaarch(String vpnbarringname, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageVPNs_Opco.click();
		Calllistconfiguration_ManageVPNs.click();
		barrierSeachbox_Calllistconfiguration.sendKeys(vpnbarringname);
		Thread.sleep(2000);
		Searchicon_vpnbarringname.click();
try{
		if((usertable_ManageVPNs.getText()).contains(vpnbarringname))
		{
			
			test.log(Status.PASS, "get calllistconfigurations successfully");
			//JavascriptExecutor jse = (JavascriptExecutor) driver;
			//jse.executeScript("window.scrollBy(0,2650)", "");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
			System.out.println("get calllistconfigurations successfully");
		}
}

		catch(Exception e)
		{	
			test.log(Status.INFO, "do not get calllistconfigurations successfully");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("do not get calllistconfigurations successfully");
			test.log(Status.FAIL, "Sims search is NOT FOUND");
		}

		
		
		
		
		
	}
	
}
