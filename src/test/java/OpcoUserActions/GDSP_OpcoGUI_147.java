package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_147 {
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

	@FindBy(xpath="//a[@href='manage_processing_information.htm']")
	public static WebElement processinginfo_Network;

	@FindBy(name="formSearchValue")
	public static WebElement searchbox_KPIfilter;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_KPIfilter;
	@FindBy(id="overviewtable3")
	public static WebElement searchtable_processinginformation;
	public static WebDriver driver;

	public GDSP_OpcoGUI_147(WebDriver driver)
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

	public void Kpifilter( String  kpiname,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Network_Opco.click();
		Thread.sleep(2000);
		processinginfo_Network.click();
		searchbox_KPIfilter.sendKeys(kpiname);
		searchicon_KPIfilter.click();

		try{
			if( (searchtable_processinginformation.getText()).contains(kpiname))
			{
				test.log(Status.INFO, "successfully get the list of KPI trends successfully using filters." );
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				test.log(Status.PASS,"successfully get the list of KPI trends successfully using filters");
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO,"getting the list of KPI trend can not be done");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			test.log(Status.FAIL,"getting the list of the list of KPI trend can not be done");	
		}

	}

}






