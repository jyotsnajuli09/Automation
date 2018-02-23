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

public class GDSP_PlatformGUI_024 {


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

	@FindBy(name="formSearchValue2")
	public static WebElement SGSNIPAddressSearchBox_ManageSGSNMappings;

	@FindBy(xpath="//*[@id='wrapper']/div/table[1]/tbody/tr/td[7]/input")
	public static WebElement SearchIcon_ManageSGSNMappings;

	//id = overviewtable3
	@FindBy(id="overviewtable3")
	public static WebElement overviewTable_ManageSGSNMappings;

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement EditLink_ManageSGSNMappings;

	@FindBy(id="sgsn.sgnsIpAddrType")
	public static WebElement SGSNAddressType_EditnewSGSN;

	@FindBy(id="sgsn.sgsnIpAddress")
	public static WebElement SGSNIPAddress_EditnewSGSN;

	@FindBy(id="sgsn.vfOpCoId")
	public static WebElement OpcoCode_EditnewSGSN;

	@FindBy(xpath="//input[@value='Save']")
	public static WebElement save_EditnewSGSN;
	
	@FindBy(xpath="//p[@class='validationmessage']")
	public static WebElement errormessage_SGSNMappings;

	public static WebDriver driver;

	public GDSP_PlatformGUI_024(WebDriver driver)
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


	public void editSGSNMapping(String SGSNAddressType, String ipAddress, com.aventstack.extentreports.ExtentTest test,String tcid, String opcoCode) throws ClassNotFoundException, SQLException, IOException
	{
		ManageSystem_PlatformTab.click();
		SGSNMapping_ManageAAAClients.click();
		SGSNIPAddressSearchBox_ManageSGSNMappings.sendKeys(ipAddress);
		SearchIcon_ManageSGSNMappings.click();
		test.log(Status.INFO, "Search is found for given SGSN");
		try{
		if(EditLink_ManageSGSNMappings.isDisplayed())
		{
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			EditLink_ManageSGSNMappings.click();
			Select SGSNAdreesType = new Select(SGSNAddressType_EditnewSGSN);
			SGSNAdreesType.selectByVisibleText(SGSNAddressType);
			SGSNIPAddress_EditnewSGSN.clear();
			SGSNIPAddress_EditnewSGSN.sendKeys(ipAddress);
			Select OpcoCode = new Select(OpcoCode_EditnewSGSN);
			OpcoCode.selectByVisibleText(opcoCode);	
			save_EditnewSGSN.click();
			
			try
			{
			  if(errormessage_SGSNMappings.getText().contains("error"))
			  {
				  test.log(Status.INFO, errormessage_SGSNMappings.getText());
				  test.log(Status.INFO, "edit has not been done because of above error");
				  String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath2);
			  }
			}
			catch(Exception e1){
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			test.log(Status.INFO, "edit has been done successfully");
			Database.tc024(ipAddress);
			test.log(Status.INFO, "created SGSN Mapping has been verified in DB");
			}
		}}
		catch(Exception e1)
		{
			test.log(Status.INFO, "SGSN Mapping search not found");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			test.log(Status.FAIL, "EDIT is not successful since given SGSN Mapping is not available");
			
		}
	}

}
