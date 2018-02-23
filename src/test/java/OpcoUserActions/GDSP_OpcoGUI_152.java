package OpcoUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_OpcoGUI_152 {
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
	
	@FindBy(xpath="//a[@href='manage_apn_overview.htm']")
	public static WebElement UsageInformation_ConfigureNetworkTrace;
	
	@FindBy(name="formSearchValue")
	public static WebElement KPINameSearchbox_UsageInformation;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement KPINameSearchicon_UsageInformation;
	
	@FindBy(id="overviewtable3")
	public static WebElement KPINameTable_UsageInformation;
	
	public static WebDriver driver;
	
	public GDSP_OpcoGUI_152(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
		test.log(Status.INFO, "Login is successful");
			
	}

	public void KpiFilter(String kpiname, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		Network_Opco.click();
		UsageInformation_ConfigureNetworkTrace.click();
		KPINameSearchbox_UsageInformation.sendKeys(kpiname);
		KPINameSearchicon_UsageInformation.click();
		try{
			
		
		if(KPINameTable_UsageInformation.getText().contains(kpiname))
		{
			test.log(Status.PASS, "search is successful for given KPI name");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		    test.addScreenCaptureFromPath(screenShotPath2);			
		}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "search is not found for given KPI name");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		    test.addScreenCaptureFromPath(screenShotPath3);	
		}
			
	}

}
