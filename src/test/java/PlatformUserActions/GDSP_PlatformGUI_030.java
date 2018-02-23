package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_030 {
	
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
	
	@FindBy(id="submit")
	public static WebElement Create_ManageSIMProfiles;
	
	@FindBy(name="simProfile.simProfileCode")
	public static WebElement SIMProfileName_CreateNewSIMProfiles;
	
	@FindBy(name="simProfile.simProfileDesc")
	public static WebElement SIMProfileDescription_CreateNewSIMProfiles;
	
	@FindBy(name="simProfile.imsiType")
	public static WebElement IMSIType_CreateNewSIMProfiles;
	
	@FindBy(name="simProfile.formFactor")
	public static WebElement FormFactor_CreateNewSIMProfiles;
	
	@FindBy(name="simProfile.manufacturer")
	public static WebElement Manufacturer_CreateNewSIMProfiles;
	
	@FindBy(name="simProfile.plmnListId")
	public static WebElement PLMNList_CreateNewSIMProfiles;
	
	@FindBy(id="submit")
	public static WebElement save_CreateNewSIMProfiles;
	
	@FindBy(name="formSearchValue")
	public static WebElement SIMProfileNameSearchBox_ManageSIMProfiles;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageSIMProfiles;
	
	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement SIMProfileNameSearchIcon_ManageSIMProfiles;
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_030(WebDriver driver)
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
	
	public void createSIMProfile(String SName,String SDescription,String IMSIType,String FormFactor, String Manufacturer,String PLMNList,com.aventstack.extentreports.ExtentTest test,String tcid) throws ClassNotFoundException, SQLException
	{
		ManageSystem_PlatformTab.click();
		SIMProfiles_ManageSystemTab.click();
		Create_ManageSIMProfiles.click();
		SIMProfileName_CreateNewSIMProfiles.sendKeys(SName);
		SIMProfileDescription_CreateNewSIMProfiles.sendKeys(SDescription);
		Select imsiType = new Select(IMSIType_CreateNewSIMProfiles);
		imsiType.selectByVisibleText(IMSIType);	
		Select formFactor = new Select(FormFactor_CreateNewSIMProfiles);
		formFactor.selectByVisibleText(FormFactor);	
		Select manuf = new Select(Manufacturer_CreateNewSIMProfiles);
		manuf.selectByVisibleText(Manufacturer);		
		Select plmnList = new Select(PLMNList_CreateNewSIMProfiles);
		plmnList.selectByVisibleText(PLMNList);
		save_CreateNewSIMProfiles.click();
		
		
			
	      }
	
	public void searchSIMProfile(String SName,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException, Exception, SQLException
	   {
		SIMProfiles_ManageSystemTab.click();
		SIMProfileNameSearchBox_ManageSIMProfiles.sendKeys(SName);
		SIMProfileNameSearchIcon_ManageSIMProfiles.click();
		
		if((Usertable_ManageSIMProfiles.getText()).contains(SName))
		{
			test.log(Status.INFO, "Search for created SIM profile has been suceesful");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			System.out.println("Search for created SIM profile has been suceesful");
			Database.tc030(SName);
			test.log(Status.INFO,"db has been verified successfully");
		}
		
		else
		{
			test.log(Status.INFO, "Search result for created SIM profile is not found");
			System.out.println("Search result for created SIM profile is not found");
	    	}
	     }

}
