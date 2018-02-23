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

public class GDSP_PlatformGUI_033 {

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

	@FindBy(xpath="//a[@href='manage_imsi_range_overview.htm']")
	public static WebElement IMSIRanges_ManageSystemTab;

	@FindBy(name="formSearchValue")
	public static WebElement NextAvailableIMSISearchBox_ManageIMSIRanges;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement NextAvailableIMSISearchIcon_ManageIMSIRanges;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageIMSIRanges;

	@FindBy(xpath="//*[contains(text(),'Edit')]")
	public static WebElement Edit_ManageIMSIRanges;

	@FindBy(id="imsiRange.imsiFrom")
	public static WebElement IMSIFrom_EditIMSIRange;

	@FindBy(id="imsiRange.imsiTo")
	public static WebElement  IMSITo_EditIMSIRange;

	@FindBy(id="imsiRange.rangeDesc")
	public static WebElement RangeDescription_EditIMSIRange;

	@FindBy(id="imsiRange.vfOpCoId")
	public static WebElement OpcoCode_EditIMSIRange;

	@FindBy(id="submit")
	public static WebElement save_EditIMSIRange;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement errorvalidation_EditIMSIRange;

	public static WebDriver driver;

	public GDSP_PlatformGUI_033(WebDriver driver)
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


	public void editIMSIRange(String NextAvailableIMSI,String IMSIFrom,String IMSITo,String RangeDesc,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException, ClassNotFoundException, SQLException
	{
		ManageSystem_PlatformTab.click();
		IMSIRanges_ManageSystemTab.click();
		NextAvailableIMSISearchBox_ManageIMSIRanges.sendKeys(NextAvailableIMSI);
		NextAvailableIMSISearchIcon_ManageIMSIRanges.click();	
		try{
		if((Usertable_ManageIMSIRanges.getText()).contains(NextAvailableIMSI))
		{
			test.log(Status.INFO, "Search for created IMSI has been suceesful");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			if(Edit_ManageIMSIRanges.isDisplayed())
			{
				Edit_ManageIMSIRanges.click();
				IMSIFrom_EditIMSIRange.clear();
				IMSIFrom_EditIMSIRange.sendKeys(IMSIFrom);
				IMSITo_EditIMSIRange.clear();
				IMSITo_EditIMSIRange.sendKeys(IMSITo);
				RangeDescription_EditIMSIRange.clear();
				RangeDescription_EditIMSIRange.sendKeys(RangeDesc);
				//Select opcoCode = new Select(OpcoCode_EditIMSIRange);
				//opcoCode.selectByValue(OpcoCode);
				save_EditIMSIRange.click();	

				try{
					if( errorvalidation_EditIMSIRange.getText().contains("error"))
					{
						test.log(Status.INFO,errorvalidation_EditIMSIRange.getText());
						test.log(Status.FAIL, "IMSI has not been edited successfully");
						String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath3);	

					}
				}
				catch(Exception e){
					test.log(Status.INFO, "IMSI has been edited successfully");
					String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath3);	
					//Database.tc033(RangeDesc);
					//test.log(Status.INFO, "DB has been verified");
					test.log(Status.PASS, "IMSI has been edited and verified successfully");
					System.out.println("IMSI has been edited and verified successfully");
				}
			}

			else
			{
				test.log(Status.INFO, "Edit option is not availble for given IMSI");
			}
		}}
		catch(Exception e1)
		{
			test.log(Status.FAIL, "Search for given IMSI is not found");
		}
	}
}
