package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_143 {
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
	
	@FindBy(name="formSearchValue")
	public static WebElement searchbox_apnconfigurenetworktrace;
	
	@FindBy(xpath="//*[@id='wrapper']/div/table[1]/tbody/tr/td[4]/input")
	public static WebElement searchicon_apnconfigurenetworktrace;
	@FindBy(id="overviewtable3")
	public static WebElement searchtable_apnconfigurenetworktrace;
	public static WebDriver driver;

	public GDSP_OpcoGUI_143(WebDriver driver)
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

	public void apnprofilefilter( String apnprofile,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Network_Opco.click();
		Thread.sleep(2000);
		searchbox_apnconfigurenetworktrace.sendKeys(apnprofile);
		searchicon_apnconfigurenetworktrace.click();
		
		try{
			if( (searchtable_apnconfigurenetworktrace.getText()).contains(apnprofile))
			{
				
		
		
		
		
		
	
		
		test.log(Status.INFO, "successfully get the list of Network Trace using filters." );
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		test.log(Status.PASS,"successfully get the list of Network Trace  using filters");
		Thread.sleep(2000);
			}
		}
	catch(Exception e)
	{
		test.log(Status.INFO,"getting the list of network tarce can not be done");
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		test.log(Status.FAIL,"getting the list of network tarce can not be done");	
	}
	
}

}

	


