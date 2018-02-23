package PlatformUserActions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_034 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_ggsn_overview.htm']")
	public static WebElement ManageSystem_PlatformTab;

	@FindBy(xpath="//a[@href='manage_imsi_range_overview.htm']")
	public static WebElement IMSIRanges_ManageSystemTab;

	@FindBy(name="formSearchValue")
	public static WebElement NextAvailableIMSISearchBox_ManageIMSIRanges;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement NextAvailableIMSISearchIcon_ManageIMSIRanges;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageIMSIRanges;

	@FindBy(xpath="//*[contains(text(),'Delete')]")
	public static WebElement Delete_ManageIMSIRanges;
	
	@FindBy(xpath="//input[@value='Ok']")
	public static WebElement popup_ok;

	public static WebDriver driver;

	public GDSP_PlatformGUI_034(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password)
	{	
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();	
	}

	public void searchIMSIRange(String NextAvailableIMSI,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException
	{
		ManageSystem_PlatformTab.click();
		IMSIRanges_ManageSystemTab.click();
		NextAvailableIMSISearchBox_ManageIMSIRanges.sendKeys(NextAvailableIMSI);
		NextAvailableIMSISearchIcon_ManageIMSIRanges.click();
		try{
		if((Usertable_ManageIMSIRanges.getText()).contains(NextAvailableIMSI))
		{
			test.log(Status.INFO, "Search for given IMSI has been suceesful");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			try{
			if(Delete_ManageIMSIRanges.isDisplayed())
			{
				Delete_ManageIMSIRanges.click();
				Thread.sleep(2000);
				String Parent = driver.getWindowHandle();
				String subWindowHandler = null;
				Set<String> handles = driver.getWindowHandles(); 
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext())
				{
					subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler);
				popup_ok.click();
				driver.switchTo().window(Parent);
				test.log(Status.PASS, "User has been created successfully");
				IMSIRanges_ManageSystemTab.click();
				NextAvailableIMSISearchBox_ManageIMSIRanges.sendKeys(NextAvailableIMSI);
				NextAvailableIMSISearchIcon_ManageIMSIRanges.click();
				test.log(Status.PASS, "IMSI has been deleted successfully");
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);	
			}}
			catch(Exception e)
			{
				test.log(Status.INFO, "Delete option is not available for given IMSI");	
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);	
			}
		
		}}		
		catch(Exception e1)
		{
			test.log(Status.FAIL, "Search result for given IMSI profile is not found");
			
		}
	}




}
