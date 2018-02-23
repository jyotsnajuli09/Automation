package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GDSP_PlatformGUI_027 {

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

	@FindBy(xpath="//a[@href='manage_apn_overview.htm']")
	public static WebElement APNProfiles_ManageAPNProfiles;

	@FindBy(xpath="//input[@name='formSearchValue']")
	public static WebElement APNProfileNameSearchBox_ManageAPNProfiles;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement SearchIcon_ManageAPNProfiles;

	@FindBy(id="submit")
	public static WebElement Create_ManageAPNProfiles;

	@FindBy(name="apnProfile.apnProfileName")
	public static WebElement Name_CreatenewAPNProfile;

	@FindBy(name="apnProfile.apnClass")
	public static WebElement Class_CreatenewAPNProfile;

	@FindBy(name="apnProfile.ratingGroup")
	public static WebElement RatingGroup_CreatenewAPNProfile;

	@FindBy(name="apnProfile.quotaValidityTime")
	public static WebElement CreditQuotaValidityTime_CreatenewAPNProfile;

	@FindBy(name="apnProfile.quotaTotalOctets")
	public static WebElement CreditQuotaTotalOctets_CreatenewAPNProfile;

	@FindBy(name="apnProfile.quotaHoldingTime")
	public static WebElement CreditQuotaHoldingTime_CreatenewAPNProfile;

	@FindBy(name="apnProfile.diameterCdrFileClosureTime")
	public static WebElement DiameterCdrFileClosureTime_CreatenewAPNProfile;

	@FindBy(name="apnProfile.radiusCdrFileClosureTime")
	public static WebElement RadiusCdrFileClosureTime_CreatenewAPNProfile;

	@FindBy(name="apnProfile.rulebaseId")
	public static WebElement RulebaseId_CreatenewAPNProfile;

	@FindBy(name="apnProfile.deviceNotifications")
	public static WebElement DeviceNotification_CreatenewAPNProfile;

	@FindBy(name="apnProfile.inSessionDatabaseUpdates")
	public static WebElement InsessionDatabaseUpdatesRequired_CreatenewAPNProfile;

	@FindBy(name="apnProfile.checkRadiusCredentials")
	public static WebElement CheckRadiusCredentials_CreatenewAPNProfile;

	@FindBy(name="apnProfile.checkRadiusCredentials")
	public static WebElement RadiusAuthenticationType_CreatenewAPNProfile;

	@FindBy(id="submit")
	public static WebElement Save_CreatenewAPNProfile;

	public static WebDriver driver;

	public GDSP_PlatformGUI_027(WebDriver driver)
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

	public void createAPN(String Name,String Class,String RG,String CQVT,String CQTO,String CQHT,String DCFCI,String RCFCI,String RulebaseId,String DeviceNotification,String ISDUR,String CRC,String RAT,com.aventstack.extentreports.ExtentTest test,String tcid)
	{
		ManageSystem_PlatformTab.click();
		APNProfiles_ManageAPNProfiles.click();
		Create_ManageAPNProfiles.click();
		Name_CreatenewAPNProfile.sendKeys(Name);

		Select className = new Select(Class_CreatenewAPNProfile);
		className.selectByVisibleText(Class);

		Select ratingGroup = new Select(RatingGroup_CreatenewAPNProfile);
		ratingGroup.selectByVisibleText(RG);

		CreditQuotaValidityTime_CreatenewAPNProfile.sendKeys(CQVT);
		CreditQuotaTotalOctets_CreatenewAPNProfile.sendKeys(CQTO);
		CreditQuotaHoldingTime_CreatenewAPNProfile.sendKeys(CQHT);
		DiameterCdrFileClosureTime_CreatenewAPNProfile.sendKeys(DCFCI);
		RadiusCdrFileClosureTime_CreatenewAPNProfile.sendKeys(RCFCI);
		RulebaseId_CreatenewAPNProfile.sendKeys(RulebaseId);
		Select deviceNotification = new Select(DeviceNotification_CreatenewAPNProfile);
		deviceNotification.selectByVisibleText(DeviceNotification);
		Select InsessionDatabaseUpdatesRequired = new Select(InsessionDatabaseUpdatesRequired_CreatenewAPNProfile);
		InsessionDatabaseUpdatesRequired.selectByVisibleText(ISDUR);
		if(CRC.equalsIgnoreCase("No"))
		{
			Select CheckRadiusCredentials = new Select(CheckRadiusCredentials_CreatenewAPNProfile);
			CheckRadiusCredentials.selectByVisibleText(CRC);
		}


		if(CRC.equalsIgnoreCase("Yes"))
		{
			Select CheckRadiusCredentials = new Select(CheckRadiusCredentials_CreatenewAPNProfile);
			CheckRadiusCredentials.selectByVisibleText(CRC);		
			Select RadiusAuthenticationType = new Select(RadiusAuthenticationType_CreatenewAPNProfile);
			CheckRadiusCredentials.selectByVisibleText(RAT);
		}
		Save_CreatenewAPNProfile.click();
		test.log(Status.INFO,"APN profile has been created successfully");
	}

	public void searchAPN(String Name,com.aventstack.extentreports.ExtentTest test,String tcid) throws InterruptedException, IOException
	{
		ManageSystem_PlatformTab.click();
		APNProfiles_ManageAPNProfiles.click();
		APNProfileNameSearchBox_ManageAPNProfiles.sendKeys(Name);
		SearchIcon_ManageAPNProfiles.click();
		Thread.sleep(5000);
		test.log(Status.INFO,"APN profile has been verified successfully");

	}
}
