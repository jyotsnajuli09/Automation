package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_110 {
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
	
	@FindBy(xpath="//a[@href='manage_vpn_number_lists_overview.htm']")
	public static WebElement Numberlist_managevpns;
	
	@FindBy(xpath="//input[@name='formSearchValue']")
	public static WebElement searchbox_numberlistname;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_numberlistname;
	
	@FindBy(xpath="//div[@class='tablewrapper pc70']")
	public static WebElement numlisttable_ManageVPNs;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_110(WebDriver driver)
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
	
	public void numlistfilter(String numlistname,com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	
	{
		ManageVPNs_Opco.click();
		Numberlist_managevpns.click();
		 searchbox_numberlistname.sendKeys(numlistname);
		 searchicon_numberlistname.click();
		 Thread.sleep(2000);
	try
	{
		if(numlisttable_ManageVPNs.getText().contains(numlistname))
		{
			test.log(Status.INFO, "  filteration of newnumlist is successfully done ");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
			System.out.println("filteration of newnumlist is successfully done");
			test.log(Status.PASS, "  filteration of newnumlist is successfully done ");	
	    }
	
	}
	catch(Exception e)
	{
		test.log(Status.INFO, "  filteration of newnumlist is not successfully done ");
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		Thread.sleep(2000);
		System.out.println("filteration of newnumlist is not successfully done");
		test.log(Status.PASS, "  filteration of newnumlist is not successfully done ");	
    }
	}
	
	
	
	
	
	
	
	
}
