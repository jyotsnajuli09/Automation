package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_035 {
	
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_ggsn_overview.htm']")
	public static WebElement ManageSystem_PlatformTab;
	
	@FindBy(xpath="	//a[@href='manage_throttling_overview.htm?fromPage=ManageSystem']")
	public static WebElement Throttling_ManageSystemTab;
	
	@FindBy(id="submit")
	public static WebElement create_ConfigureAPIThrottling;
	
	@FindBy(name="systemThrottling.systemEntity")
	public static WebElement EntityType_CreateAPIThrottling;
	
	@FindBy(name="systemThrottling.busServiceName")
	public static WebElement WebServiceName_CreateAPIThrottling;
	
	@FindBy(name="systemThrottling.systemMaxApiCount")
	public static WebElement CallLimit_CreateAPIThrottling;
	
	@FindBy(name="systemThrottling.systemPeriodLength")
	public static WebElement Period_CreateAPIThrottling;
	
	@FindBy(id="submit")
	public static WebElement Save_CreateAPIThrottling;
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_035(WebDriver driver)
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
	

	public void createAPIThrottling(String EntityType,String WebServiceName,String CallLimit,String Period,com.aventstack.extentreports.ExtentTest test,String tcid) throws InterruptedException, IOException
	{
		ManageSystem_PlatformTab.click();
		Throttling_ManageSystemTab.click();
		create_ConfigureAPIThrottling.click();
		test.log(Status.INFO,"clicked on create link");
		Thread.sleep(3000);
		Select entityType = new Select(EntityType_CreateAPIThrottling);
		//entityType.selectByValue(EntityType);
		entityType.selectByIndex(1);
		Thread.sleep(3000);
		Select webServiceName = new Select(WebServiceName_CreateAPIThrottling);
		webServiceName.selectByIndex(11);
		//webServiceName.selectByValue(WebServiceName);
		Thread.sleep(3000);
		CallLimit_CreateAPIThrottling.sendKeys(CallLimit);
		Thread.sleep(3000);
		Select period= new Select(Period_CreateAPIThrottling);
		period.selectByIndex(1);
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);	
		//period.selectByValue(Period);
		Save_CreateAPIThrottling.click();
		
		test.log(Status.PASS,"API throttling has been created successfully");
		System.out.println("API throttling has been created successfully");
			
	   }
	
	
	
	
	
}
