package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_104 {
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
	
	@FindBy(name="formSearchValue")
	public static WebElement searchbox_vpngrpname;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_vpngrpname;
	
	@FindBy(xpath="//a[contains(@href,'manage_restrictions')]")
	public static WebElement managerestriction_vpngrps;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_ManageVPNs;
	
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_104(WebDriver driver)
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
	public void vpnfilter(String customercode,String newvpngrpname,com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageVPNs_Opco.click();
		searchbox_vpngrpname.sendKeys(newvpngrpname);
		
		searchicon_vpngrpname.click();
		
		
		try
		{
			if((usertable_ManageVPNs.getText()).contains(newvpngrpname))
			{
				test.log(Status.INFO, " filteration is successfully done ");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				System.out.println("filteration is successfully done");
				test.log(Status.PASS, "filteration is successfully done ");
			}
		}
			
		catch(Exception e)
		
		{
			test.log(Status.INFO, " filteration is not successfully done ");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			Thread.sleep(2000);
			System.out.println("filteration is not successfully done");
			test.log(Status.PASS, "filteration is not  successfully done ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}		
	
}
