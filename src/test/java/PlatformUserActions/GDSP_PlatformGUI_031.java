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

public class GDSP_PlatformGUI_031 {

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

	@FindBy(xpath="//a[@href='manage_sim_profile_overview.htm']")
	public static WebElement SIMProfiles_ManageSystemTab;

	@FindBy(name="formSearchValue")
	public static WebElement SIMProfileNameSearchBox_ManageSIMProfiles;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement SIMProfileNameSearchIcon_ManageSIMProfiles;

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Edit_ManageSIMProfiles;

	@FindBy(name="simProfile.simProfileCode")
	public static WebElement SIMProfileName_EditSIMProfiles;

	@FindBy(name="simProfile.simProfileDesc")
	public static WebElement SIMProfileDescription_EditSIMProfiles;

	@FindBy(name="simProfile.imsiType")
	public static WebElement IMSIType_EditSIMProfiles;

	@FindBy(name="simProfile.formFactor")
	public static WebElement FormFactor_EditSIMProfiles;

	@FindBy(xpath="//p[@class='validationmessage']")
	public static WebElement errorMessage_EditSIMProfiles;

	@FindBy(name="simProfile.manufacturer")
	public static WebElement Manufacturer_EditSIMProfiles;

	@FindBy(name="simProfile.plmnListId")
	public static WebElement PLMNList_EditSIMProfiles;

	@FindBy(id="submit")
	public static WebElement save_EditSIMProfiles;

	public static WebDriver driver;

	public GDSP_PlatformGUI_031(WebDriver driver)
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

	public void searchSIMProfile(String SName,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException
	{
		ManageSystem_PlatformTab.click();
		SIMProfiles_ManageSystemTab.click();
		SIMProfileNameSearchBox_ManageSIMProfiles.sendKeys(SName);
		SIMProfileNameSearchIcon_ManageSIMProfiles.click();
	}

	public void editSIMProfile(String SName,String SDescription,String IMSIType,String FormFactor, String Manufacturer,String PLMNList,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException, ClassNotFoundException, SQLException
	{
		if(Edit_ManageSIMProfiles.isDisplayed())
		{
			test.log(Status.INFO, "Edit link is available for given SIM Profile");
			Edit_ManageSIMProfiles.click();
			SIMProfileName_EditSIMProfiles.clear();
			SIMProfileName_EditSIMProfiles.sendKeys(SName);
			SIMProfileDescription_EditSIMProfiles.clear();
			SIMProfileDescription_EditSIMProfiles.sendKeys(SDescription);
			Select imsiType = new Select(IMSIType_EditSIMProfiles);
			imsiType.selectByVisibleText(IMSIType);	
			Select formFactor = new Select(FormFactor_EditSIMProfiles);
			formFactor.selectByVisibleText(FormFactor);	
			Select manuf = new Select(Manufacturer_EditSIMProfiles);
			manuf.selectByVisibleText(Manufacturer);		
		//	Select plmnList = new Select(PLMNList_EditSIMProfiles);
		//	plmnList.selectByVisibleText(PLMNList);
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			save_EditSIMProfiles.click();

			try{
				if(errorMessage_EditSIMProfiles.getText().contains("error"))
				{
					test.log(Status.INFO, errorMessage_EditSIMProfiles.getText());
					test.log(Status.FAIL, "Edit has not done because of above error");
					String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath3);	
				}
			}
			catch(Exception e)
			{
				System.out.println("try block has not executed");
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);	
				test.log(Status.INFO, "Edit has been done successfully");
				Database.tc031(SDescription);
				test.log(Status.INFO, "DB has been verified");			
				test.log(Status.PASS, "Edit and DB validation has been done");

			}
		}

		else
		{
			test.log(Status.INFO, "Edit link is not available for given SIM Profile");
			System.out.println("Edit link is not available for given SIM Profile");
		}
	}

}
