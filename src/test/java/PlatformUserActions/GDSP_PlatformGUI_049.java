package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_049 {

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
	
	@FindBy(xpath="//a[@href='manage_usage_information.htm']")
	public static WebElement UsageInformation_NetworkTab;
	
	@FindBy(name="formSearchValue")
	public static WebElement KPINameSearchBox_UsageInformation;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement KPINameSearchIcon_UsageInformation;
	
	@FindBy(id="overviewtable3")
	public static WebElement KPITable_UsageInformation;
	
	@FindBy(xpath="//*[@id='overviewtable3']/tbody/tr[3]/td[1]/a")
	public static WebElement KPINameLink_UsageInformation;
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_049(WebDriver driver)
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
	
	public void searchKPI(String KPIName,com.aventstack.extentreports.ExtentTest test , String tcid) throws IOException, InterruptedException
	{
		Network_PlatformTab.click();
		UsageInformation_NetworkTab.click();
		KPINameSearchBox_UsageInformation.sendKeys(KPIName);
		KPINameSearchIcon_UsageInformation.click();
		if(KPITable_UsageInformation.getText().contains(KPIName))
		{
			test.log(Status.INFO, "KPI NAME is present in KPI Table");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			KPINameLink_UsageInformation.click();
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
		}
		
	}
	
	
}
