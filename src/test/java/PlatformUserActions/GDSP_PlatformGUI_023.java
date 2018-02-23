package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_023 {
	
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

	@FindBy(xpath="//a[@href='manage_sgsn_overview.htm']")
	public static WebElement SGSNMapping_ManageAAAClients;

	@FindBy(xpath="//input[@value='Create']")
	public static WebElement Create_ManageSGSNMappings;

	@FindBy(id="sgsn.sgnsIpAddrType")
	public static WebElement SGSNAddressType_CreatenewSGSN;

	@FindBy(id="sgsn.sgsnIpAddress")
	public static WebElement SGSNIPAddress_CreatenewSGSN;

	@FindBy(id="sgsn.vfOpCoId")
	public static WebElement OpcoCode_CreatenewSGSN;

	@FindBy(xpath="//input[@value='Save']")
	public static WebElement SaveButton_CreatenewSGSN;

	@FindBy(xpath="//input[@value='Cancel']")
	public static WebElement Cancel_CreatenewSGSN;

	@FindBy(name="formSearchValue2")
	public static WebElement SGSNIPAddressSearchBox_ManageSGSNMappings;
	
	@FindBy(xpath="//*[@id='wrapper']/div/table[1]/tbody/tr/td[7]/input")
	public static WebElement SearchIcon_ManageSGSNMappings;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public static WebElement errormessage_CreatenewSGSN;

	@FindBy(xpath="//input[@value='Upload']")
	public static WebElement Upload_ManageSGSNMappings;

	@FindBy(xpath="//input[@value='Upload']")
	public static WebElement Upload_UploadSGSNMappingsBatch;
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_023(WebDriver driver)
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
	
	public void createSGSNMapping(String SGSNAddressType, String ipAddress, com.aventstack.extentreports.ExtentTest test,String tcid, String opcoCode) throws ClassNotFoundException, SQLException, IOException
	{
		ManageSystem_PlatformTab.click();
		SGSNMapping_ManageAAAClients.click();
		Create_ManageSGSNMappings.click();
		Select SGSNAdreesType = new Select(SGSNAddressType_CreatenewSGSN);
		SGSNAdreesType.selectByVisibleText(SGSNAddressType);
		SGSNIPAddress_CreatenewSGSN.sendKeys(ipAddress);
		Select OpcoCode = new Select(OpcoCode_CreatenewSGSN);
		OpcoCode.selectByVisibleText(opcoCode);	
		SaveButton_CreatenewSGSN.click();
		try
		{
		if(errormessage_CreatenewSGSN.isDisplayed())
		{
		test.log(Status.INFO, errormessage_CreatenewSGSN.getText())	;
		test.log(Status.FAIL, "creation of SGSNMapping is not successful");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);	
		}
		}
		catch(Exception e)
		{
			test.log(Status.PASS, "creation of SGSNMapping is not successful");
			SGSNIPAddressSearchBox_ManageSGSNMappings.sendKeys(ipAddress);
			SearchIcon_ManageSGSNMappings.click();
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);	
			test.log(Status.INFO, "Search has been found for created SGSNMapping ");
			Database.tc023(ipAddress);
			test.log(Status.INFO, "created SGSN Mapping has been verified in DB");
		}

	}


}
