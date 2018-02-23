package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_044 {



	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
	public static WebElement Managecustomers_Opco;
	
    @FindBy(xpath="//a[@href='manage_sp_paged_overview.htm']")
    public static WebElement customerserviceprofiles_Managecustomers;
  @FindBy(xpath="//a[contains(text(),'Blended-CSP1222')]")
  public static WebElement linkofcspprofile_csp;
@FindBy(xpath="//*[@id='wrapper']")
public static WebElement table_csp;
@FindBy(xpath="//*[@id='actions']/ul/li[5]/a")
public static WebElement returntoserviceprof;
    public static WebDriver driver;

	public GDSP_OpcoGUI_044(WebDriver driver)
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

	public void csprofiles(com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomers_Opco.click();
		 Thread.sleep(3000);
	
		 customerserviceprofiles_Managecustomers.click();
		 
		
		 
		 Thread.sleep(2000);
		 
		try{
			if(table_csp.isDisplayed())
			{
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				Thread.sleep(3000);
	              linkofcspprofile_csp.click();
	              Thread.sleep(3000);
	              String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath4);
					 Thread.sleep(3000);
					returntoserviceprof.click();
					String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath5);
					test.log(Status.PASS,"back to service profile is  done successfully  ");

	}
		}
catch(Exception e)
{
	 String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath4);
		test.log(Status.FAIL,"back to service profile is not done ");
}
}
	}