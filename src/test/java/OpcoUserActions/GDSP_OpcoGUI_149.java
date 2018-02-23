package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_149 {
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
	
	@FindBy(xpath="//a[@href='manage_processing_information.htm']")
	public static WebElement refreshbutton_processinfo;

	@FindBy(name="formSearchValue")
	public static WebElement searchbox_KPIfilter;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_filter;
	@FindBy(id="overviewtable3")
	public static WebElement searchtable_processinginformation;
	public static WebDriver driver;

	public GDSP_OpcoGUI_149(WebDriver driver)
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

	public void refresh( String  kpiname,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Network_Opco.click();
		Thread.sleep(2000);
		processinginfo_Network.click();
		 refreshbutton_processinfo.click();
		 Thread.sleep(2000);
		searchbox_KPIfilter.sendKeys(kpiname);
		searchicon_filter.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(kpiname)).click();;
		System.out.println("kfdfgh");
		Thread.sleep(2000);
	

		try{
			if(searchtable_processinginformation.isDisplayed())
			{
				test.log(Status.INFO, "Refresh is done and successfully get the data through kpiname filters." );
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				System.out.println("Refresh is done and successfully get the data through kpiname filters.");
				test.addScreenCaptureFromPath(screenShotPath2);
				test.log(Status.PASS,"Refresh is done and successfully get the data through kpiname filters.");
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO," Refresh is not done and did not get the data through kpiname filters.");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			System.out.println("Refresh is not done and did not get the data through kpiname filters");
			test.addScreenCaptureFromPath(screenShotPath3);
			test.log(Status.FAIL,"Refresh is not done and did not get the data through kpiname filters");	
		}

	}

}

