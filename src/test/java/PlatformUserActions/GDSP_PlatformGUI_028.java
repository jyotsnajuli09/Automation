package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_028 {

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

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Edit_ManageAPNProfiles;

	@FindBy(name="apnProfile.apnProfileName")
	public static WebElement Name_EditAPNProfileDetails;

	@FindBy(name="apnProfile.apnClass")
	public static WebElement Class_EditAPNProfileDetails;

	@FindBy(name="apnProfile.ratingGroup")
	public static WebElement RatingGroup_EditAPNProfileDetails;

	@FindBy(name="apnProfile.quotaValidityTime")
	public static WebElement CreditQuotaValidityTime_EditAPNProfileDetails;

	@FindBy(name="apnProfile.quotaTotalOctets")
	public static WebElement CreditQuotaTotalOctets_EditAPNProfileDetails;

	@FindBy(name="apnProfile.quotaHoldingTime")
	public static WebElement CreditQuotaHoldingTime_EditAPNProfileDetails;

	@FindBy(name="apnProfile.diameterCdrFileClosureTime")
	public static WebElement DiameterCdrFileClosureTime_EditAPNProfileDetails;

	@FindBy(name="apnProfile.radiusCdrFileClosureTime")
	public static WebElement RadiusCdrFileClosureTime_EditAPNProfileDetails;

	@FindBy(name="apnProfile.rulebaseId")
	public static WebElement RulebaseId_EditAPNProfileDetails;

	@FindBy(name="apnProfile.deviceNotifications")
	public static WebElement DeviceNotification_EditAPNProfileDetails;

	@FindBy(name="apnProfile.inSessionDatabaseUpdates")
	public static WebElement InsessionDatabaseUpdatesRequired_EditAPNProfileDetails;

	@FindBy(name="apnProfile.inSessionDatabaseUpdates")
	public static WebElement ExtendTracingBy_EditAPNProfileDetails;

	@FindBy(name="apnProfile.checkRadiusCredentials")
	public static WebElement CheckRadiusCredentials_EditAPNProfileDetails;

	@FindBy(name="apnProfile.proxyRadiusAccountingFlag")
	public static WebElement ExternalRADIUSAccounting_EditAPNProfileDetails;

	@FindBy(id="submit")
	public static WebElement Save_EditAPNProfileDetails;

	public static WebDriver driver;

	public GDSP_PlatformGUI_028(WebDriver driver)
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

	public void searchAPN(String Name,com.aventstack.extentreports.ExtentTest test,String tcid) throws InterruptedException, IOException
	{
		ManageSystem_PlatformTab.click();
		APNProfiles_ManageAPNProfiles.click();
		APNProfileNameSearchBox_ManageAPNProfiles.sendKeys(Name);
		SearchIcon_ManageAPNProfiles.click();
		Thread.sleep(5000);
		test.log(Status.INFO,"search has been done successfully");

	}
	public void editAPN(String Name,String Class,String RG,String CQVT,String CQTO,String CQHT,String DCFCI,String RCFCI,String RulebaseId,String DeviceNotification,String ISDUR,String ETBY, String CRC,String ERA,com.aventstack.extentreports.ExtentTest test,String tcid)
	{

		if(Edit_ManageAPNProfiles.isDisplayed())
		{
			Edit_ManageAPNProfiles.click();
			Name_EditAPNProfileDetails.clear();
			Name_EditAPNProfileDetails.sendKeys(Name);
			Select className = new Select(Class_EditAPNProfileDetails);
			className.selectByVisibleText(Class);
			Select ratingGroup = new Select( RatingGroup_EditAPNProfileDetails);
			ratingGroup.selectByVisibleText(RG);
			CreditQuotaValidityTime_EditAPNProfileDetails.clear();
			CreditQuotaValidityTime_EditAPNProfileDetails.sendKeys(CQVT);
			CreditQuotaTotalOctets_EditAPNProfileDetails.clear();
			CreditQuotaTotalOctets_EditAPNProfileDetails.sendKeys(CQTO);
			CreditQuotaHoldingTime_EditAPNProfileDetails.clear();
			CreditQuotaHoldingTime_EditAPNProfileDetails.sendKeys(CQHT);
			DiameterCdrFileClosureTime_EditAPNProfileDetails.clear();
			DiameterCdrFileClosureTime_EditAPNProfileDetails.sendKeys(DCFCI);
			RadiusCdrFileClosureTime_EditAPNProfileDetails.clear();
			RadiusCdrFileClosureTime_EditAPNProfileDetails.sendKeys(RCFCI);
			RulebaseId_EditAPNProfileDetails.clear();
			RulebaseId_EditAPNProfileDetails.sendKeys(RulebaseId);
			Select deviceNotification = new Select(DeviceNotification_EditAPNProfileDetails);
			deviceNotification.selectByVisibleText(DeviceNotification);
			Select InsessionDatabaseUpdatesRequired = new Select(InsessionDatabaseUpdatesRequired_EditAPNProfileDetails);
			InsessionDatabaseUpdatesRequired.selectByVisibleText(ISDUR);	
			Select ExtendTracingBy= new Select(ExtendTracingBy_EditAPNProfileDetails);
			ExtendTracingBy.selectByVisibleText(ETBY);
			Select CheckRadiusCredentials= new Select(CheckRadiusCredentials_EditAPNProfileDetails);
			CheckRadiusCredentials.selectByVisibleText(CRC);
			Select ExternalRADIUSAccounting= new Select(ExternalRADIUSAccounting_EditAPNProfileDetails);
			ExternalRADIUSAccounting.selectByVisibleText(ERA);
			Save_EditAPNProfileDetails.click();	
			test.log(Status.INFO,"edit has been done successfully");
		}
		else
		{
			System.out.println("Edit link is not availbale");
		}

	}

}
