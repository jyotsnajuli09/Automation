package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_053 {

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

	@FindBy(xpath="//a[@href='manage_roaming_groups.htm']")
	public static WebElement RoamingGroupProfiles_ManageAAAClients;

	@FindBy(id="submit")
	public static WebElement Create_ManageRoamingProfiles;

	@FindBy(name="roamingGroupProfile.serviceCoverageGroupName")
	public static WebElement RoamingGroupName_CreatenewRoamingGroup;

	@FindBy(name="roamingGroupProfile.serviceCoverageGroupDesc")
	public static WebElement RoamingGroupDescription_CreatenewRoamingGroup;

	@FindBy(name="ghlrGroupId")
	public static WebElement GHLRGroup_CreatenewRoamingGroup;

	@FindBy(name="externalSCAIdMandatory")
	public static WebElement ExternalServiceCoverageAreaIdentifier_CreatenewRoamingGroup;

	@FindBy(id="submit")
	public static WebElement Save_CreatenewRoamingGroup;

	@FindBy(name="formSearchValue1")
	public static WebElement GroupNameSearchBox_ManageRoamingProfiles;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement GroupNameSearchIcon_ManageRoamingProfiles;

	@FindBy(id="overviewtable3")
	public static WebElement RoamingProfileTable_ManageRoamingProfiles;

	public static WebDriver driver;

	public GDSP_PlatformGUI_053(WebDriver driver)
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

	public void createnewRoamingGroup(String RGName, String RGDescription, String GhlrGroup, String ESCAIdentifier,com.aventstack.extentreports.ExtentTest test, String tcid)
	{
		ManageSystem_PlatformTab.click();
		RoamingGroupProfiles_ManageAAAClients.click();
		Create_ManageRoamingProfiles.click();
		test.log(Status.INFO, "clicked on create button");
		RoamingGroupName_CreatenewRoamingGroup.sendKeys(RGName);
		RoamingGroupDescription_CreatenewRoamingGroup.sendKeys(RGDescription);
		Select GHLRGroup = new Select(GHLRGroup_CreatenewRoamingGroup);
		GHLRGroup.selectByVisibleText(GhlrGroup);
		//ExternalServiceCoverageAreaIdentifier_CreatenewRoamingGroup.sendKeys(ESCAIdentifier);
		Save_CreatenewRoamingGroup.click();
		test.log(Status.INFO, "Roaming group creation is successful");

	}

	public void searchRoamingGroup(String RGName,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, ClassNotFoundException, SQLException
	{
		RoamingGroupProfiles_ManageAAAClients.click();
		GroupNameSearchBox_ManageRoamingProfiles.sendKeys(RGName);
		GroupNameSearchIcon_ManageRoamingProfiles.click();
		if(RoamingProfileTable_ManageRoamingProfiles.getText().contains(RGName))
		{
			test.log(Status.INFO, "Search for created Roaming group is successful");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Database.tc053(RGName);
			test.log(Status.INFO, "Db has been verified");
			
		}
		else
		{
			test.log(Status.INFO, "Search for created Roaming group is not found");
		}

	  }

   }
