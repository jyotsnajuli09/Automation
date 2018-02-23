package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_047 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_apn_usage_overview.htm']")
	public static WebElement Network_PlatformTab;
	
	@FindBy(name="formSearchValue")
	public static WebElement APNSearchList_APNUsage;
	
	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement APNListSearchIcon_APNUsage;
	
	@FindBy(id="overviewtable3")
	public static WebElement APNTable_APNUsage;
	
	@FindBy(xpath="//*[@id='overviewtable3']/tbody/tr[2]/td[1]/a")
	public static WebElement firstAPNProfileNameAvailable_APNUsage;
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_047(WebDriver driver)
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

   public void searchAPN(com.aventstack.extentreports.ExtentTest test , String tcid) throws IOException
	{	
		Network_PlatformTab.click();
		String ApnToBeSearched= firstAPNProfileNameAvailable_APNUsage.getText();
		System.out.println("APN needs to be searched "+ ApnToBeSearched);
		Select apnList = new Select(APNSearchList_APNUsage);
		apnList.selectByVisibleText(ApnToBeSearched);
		APNListSearchIcon_APNUsage.click();
		if(APNTable_APNUsage.getText().contains(ApnToBeSearched))
		{
			test.log(Status.INFO, " Search is successful");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
		}
		else
		{
			test.log(Status.INFO, " Search is not found");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
		}

	}
}
