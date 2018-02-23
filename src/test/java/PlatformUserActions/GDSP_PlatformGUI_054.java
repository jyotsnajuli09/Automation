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

public class GDSP_PlatformGUI_054 {

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

	@FindBy(name="formSearchValue1")
	public static WebElement GroupNameSearchBox_ManageRoamingProfiles;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement GroupNameSearchIcon_ManageRoamingProfiles;

	@FindBy(id="overviewtable3")
	public static WebElement RoamingProfileTable_ManageRoamingProfiles;

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Edit_ManageRoamingProfiles;

	@FindBy(name="roamingGroupProfile.serviceCoverageGroupName")
	public static WebElement RoamingGroupName_EditRoamingGroupData;

	@FindBy(name="roamingGroupProfile.serviceCoverageGroupDesc")
	public static WebElement RoamingGroupDescription_EditRoamingGroupData;

	@FindBy(name="ghlrGroupId")
	public static WebElement GHLRGroup_EditRoamingGroupData;

	@FindBy(name="externalSCAIdMandatory")
	public static WebElement ExternalServiceCoverageAreaIdentifier_EditRoamingGroupData;

	@FindBy(id="submit")
	public static WebElement Save_EditRoamingGroupData;
	
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_EditRoamingGroupData;

	public static WebDriver driver;

	public GDSP_PlatformGUI_054(WebDriver driver)
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


	public void searchRoamingGroup(String RGName,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException
	{
		ManageSystem_PlatformTab.click();
		RoamingGroupProfiles_ManageAAAClients.click();
		GroupNameSearchBox_ManageRoamingProfiles.sendKeys(RGName);
		GroupNameSearchIcon_ManageRoamingProfiles.click();
		try{
		if(RoamingProfileTable_ManageRoamingProfiles.getText().contains(RGName))
		{
			test.log(Status.INFO, "Search for  Roaming group is successful");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
		}}
		catch(Exception e2)
		{
			test.log(Status.INFO, "Search for created Roaming group is not found");
		}

	}


	public void editRoamingGroup(String RGName, String RGDescription, String GhlrGroup, String ESCAIdentifier,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, ClassNotFoundException, SQLException
	{
		try{
		if(Edit_ManageRoamingProfiles.isDisplayed())
		{
			Edit_ManageRoamingProfiles.click();
			Select GHLRGroup = new Select(GHLRGroup_EditRoamingGroupData);
			GHLRGroup.selectByVisibleText(GhlrGroup);
			RoamingGroupDescription_EditRoamingGroupData.clear();
			RoamingGroupDescription_EditRoamingGroupData.sendKeys(RGDescription);
			ExternalServiceCoverageAreaIdentifier_EditRoamingGroupData.clear();
			ExternalServiceCoverageAreaIdentifier_EditRoamingGroupData.sendKeys(ESCAIdentifier);
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Save_EditRoamingGroupData.click();
			try{
				if(validationMesaage_EditRoamingGroupData.isDisplayed()){
					if(validationMesaage_EditRoamingGroupData.getText().contains("error"))
					{
						test.log(Status.INFO, validationMesaage_EditRoamingGroupData.getText());
						test.log(Status.FAIL, "Roaming group does not edited successfully");
						String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath4);
					}
				}	

			}
			catch(Exception e1)
			{
				test.log(Status.INFO, "Edit for Roaming group is successful");	
				Database.tc054(RGName);
				test.log(Status.INFO, "Db has been verified");
				test.log(Status.PASS,"Edit BSG is successful");
			}
			
		}}

		catch(Exception e)
		{
			test.log(Status.INFO, "Edit option for given Roaming group is not available");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			test.log(Status.FAIL, "EDIT is not successful since given Roaming group is not available");
		}

	}

}
