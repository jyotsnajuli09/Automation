package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_048 {

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

	@FindBy(xpath="//a[@href='manage_processing_information.htm']")
	public static WebElement Processinginformation_NetworkTab;

	@FindBy(name="formSearchValue")
	public static WebElement KPINameSearchBox_ProcessingInformation;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement KPINameSearchIcon_ProcessingInformation;

	@FindBy(xpath="//*[@id='overviewtable3']/tbody/tr[3]/td[1]/a")
	public static WebElement KPINameLink_ProcessingInformation;

	@FindBy(name="formSearchValue")
	public static WebElement OpcoCodeSearchBox_ProcessingInformation;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement OpcoCodeSearchIcon_ProcessingInformation;

	@FindBy(xpath="//*[@id='overviewtable3']/tbody/tr[2]/td[1]/a")
	public static WebElement OpcoCodeLink_ProcessingInformation;

	@FindBy(id="overviewtable3")
	public static WebElement KPITable_ProcessingInformation;

	public static WebDriver driver;

	public GDSP_PlatformGUI_048(WebDriver driver)
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

	public void searchKPI(String KPIName, String OpcoCode, com.aventstack.extentreports.ExtentTest test , String tcid) throws IOException, InterruptedException
	{
		Network_PlatformTab.click();
		Processinginformation_NetworkTab.click();
		KPINameSearchBox_ProcessingInformation.sendKeys(KPIName);
		KPINameSearchIcon_ProcessingInformation.click();
		try{
			if(KPITable_ProcessingInformation.getText().contains(KPIName))
			{
				test.log(Status.INFO, "KPI NAME is present in KPI Table");
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				KPINameLink_ProcessingInformation.click(); 
				Thread.sleep(5000);
				OpcoCodeSearchBox_ProcessingInformation.sendKeys(OpcoCode);
				String screenShotPath6=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath6);
				OpcoCodeSearchIcon_ProcessingInformation.click();
				try
				{
					if(KPITable_ProcessingInformation.getText().contains(OpcoCode))
					{
						test.log(Status.INFO, "Opco code is present in Processing Information Page"); 
						String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath4);	 
						OpcoCodeLink_ProcessingInformation.click();
						test.log(Status.INFO, "customer code is displayed with KPI Value on Processing Information Page"); 
						String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath5);
					}
				}
				catch(Exception e1)
				{
					test.log(Status.INFO, "Opco code is not present on Processing Information Page"); 
				}

			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO, "KPI NAME is Not present in KPI Table");
		}
	}

}
