package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_045 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_plmn_list_overview.htm']")
	public static WebElement ManagePLMNList_PlatformTab;

	@FindBy(name="formSearchValue")
	public static WebElement PLMNListNameSearchBox_ManagePLMNList;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement PLMNListNameSearchIcon_ManagePLMNList;

	@FindBy(id="overviewtable3")
	public static WebElement PLMNTable_ManagePLMNList;

	@FindBy(xpath="//a[contains(text(),'Copy')]")
	public static WebElement Copy_ManagePLMNList;

	@FindBy(id="plmn.plmnListName")
	public static WebElement PlmnListName_CopyPLMNList;

	@FindBy(id="plmn.plmnListDesc")
	public static WebElement PlmnListDescription_CopyPLMNList;

	@FindBy(id="plmn.plmnListReference")
	public static WebElement PlmnListReference_CopyPLMNList;

	@FindBy(id="submit")
	public static WebElement Save_CopyPLMNList;


	public static WebDriver driver;

	public GDSP_PlatformGUI_045(WebDriver driver)
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



	public void searchPLMNList(String Name,String NewName, String Description, String  Reference,String copyreference,com.aventstack.extentreports.ExtentTest test , String tcid) throws IOException, ClassNotFoundException, SQLException
	{	
		ManagePLMNList_PlatformTab.click();
		PLMNListNameSearchBox_ManagePLMNList.sendKeys(Name);
		PLMNListNameSearchIcon_ManagePLMNList.click();

		if(PLMNTable_ManagePLMNList.getText().contains(Name))
		{
			test.log(Status.INFO, " Search is successful for given PLMN List");

			if(Copy_ManagePLMNList.isDisplayed())
			{
				Copy_ManagePLMNList.click();
				PlmnListName_CopyPLMNList.clear();
				PlmnListName_CopyPLMNList.sendKeys(NewName);
				PlmnListDescription_CopyPLMNList.clear();
				PlmnListDescription_CopyPLMNList.sendKeys(Description);
				PlmnListReference_CopyPLMNList.clear();
				PlmnListReference_CopyPLMNList.sendKeys(copyreference);
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				Save_CopyPLMNList.click();
				test.log(Status.INFO, " Copy for given PLMN List is successful");
				System.out.println("Copy for given PLMN List is successful");
				test.log(Status.INFO, "Db has been verified");
				Database.tc045(Name,Reference);
				System.out.println("deletion of old plmnlist is done");
			}
			else
			{
				test.log(Status.INFO, "copy link is not present for given PLMN List");
			}

		}
		else
		{
			test.log(Status.INFO, " Search is not found for given PLMN List");
			test.log(Status.INFO, " Copy for given PLMN List is not done");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
		}

	}


}
