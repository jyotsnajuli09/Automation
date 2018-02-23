package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_029 {
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
	
	@FindBy(xpath="//a[contains(text(),'Copy')]")
	public static WebElement Copy_ManageAPNProfiles;


	@FindBy(name="apnProfile.apnProfileName")
	public static WebElement Name_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.apnClass")
	public static WebElement Class_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.ratingGroup")
	public static WebElement RatingGroup_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.quotaValidityTime")
	public static WebElement CreditQuotaValidityTime_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.quotaTotalOctets")
	public static WebElement CreditQuotaTotalOctets_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.quotaHoldingTime")
	public static WebElement CreditQuotaHoldingTime_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.diameterCdrFileClosureTime")
	public static WebElement DiameterCdrFileClosureTime_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.radiusCdrFileClosureTime")
	public static WebElement RadiusCdrFileClosureTime_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.rulebaseId")
	public static WebElement RulebaseId_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.deviceNotifications")
	public static WebElement DeviceNotification_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.inSessionDatabaseUpdates")
	public static WebElement InsessionDatabaseUpdatesRequired_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.checkRadiusCredentials")
	public static WebElement CheckRadiusCredentials_CopyAPNProfileDetails;

	@FindBy(name="apnProfile.checkRadiusCredentials")
	public static WebElement RadiusAuthenticationType_CopyAPNProfileDetails;

	@FindBy(id="submit")
	public static WebElement Save_CopyAPNProfileDetails;

	public static WebDriver driver;

	public GDSP_PlatformGUI_029(WebDriver driver)
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

	public void copyAPN(String Name,String Class,String RG,String CQVT,String CQTO,String CQHT,String DCFCI,String RCFCI,String RulebaseId,String DeviceNotification,String ISDUR,String CRC,String RAT,com.aventstack.extentreports.ExtentTest test,String tcid)
	{
		ManageSystem_PlatformTab.click();
		APNProfiles_ManageAPNProfiles.click();
		Copy_ManageAPNProfiles.click();
		Name_CopyAPNProfileDetails.sendKeys(Name);

		Select className = new Select(Class_CopyAPNProfileDetails);
		className.selectByVisibleText(Class);

		Select ratingGroup = new Select(RatingGroup_CopyAPNProfileDetails);
		ratingGroup.selectByVisibleText(RG);

		CreditQuotaValidityTime_CopyAPNProfileDetails.sendKeys(CQVT);
		CreditQuotaTotalOctets_CopyAPNProfileDetails.sendKeys(CQTO);
		CreditQuotaHoldingTime_CopyAPNProfileDetails.sendKeys(CQHT);
		DiameterCdrFileClosureTime_CopyAPNProfileDetails.sendKeys(DCFCI);
		RadiusCdrFileClosureTime_CopyAPNProfileDetails.sendKeys(RCFCI);
		RulebaseId_CopyAPNProfileDetails.sendKeys(RulebaseId);
		Select deviceNotification = new Select(DeviceNotification_CopyAPNProfileDetails);
		deviceNotification.selectByVisibleText(DeviceNotification);
		Select InsessionDatabaseUpdatesRequired = new Select(InsessionDatabaseUpdatesRequired_CopyAPNProfileDetails);
		InsessionDatabaseUpdatesRequired.selectByVisibleText(ISDUR);
		if(CRC.equalsIgnoreCase("No"))
		{
			Select CheckRadiusCredentials = new Select(CheckRadiusCredentials_CopyAPNProfileDetails);
			CheckRadiusCredentials.selectByVisibleText(CRC);
		}


		if(CRC.equalsIgnoreCase("Yes"))
		{
			Select CheckRadiusCredentials = new Select(CheckRadiusCredentials_CopyAPNProfileDetails);
			CheckRadiusCredentials.selectByVisibleText(CRC);		
			Select RadiusAuthenticationType = new Select(RadiusAuthenticationType_CopyAPNProfileDetails);
			CheckRadiusCredentials.selectByVisibleText(RAT);
		}
		Save_CopyAPNProfileDetails.click();
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
