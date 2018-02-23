package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_044 {

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

	@FindBy(id="submit")
	public static WebElement Create_ManagePLMNList;

	@FindBy(id="plmn.plmnListName")
	public static WebElement PlmnListName_CreatenewPLMNList;

	@FindBy(id="plmn.plmnListDesc")
	public static WebElement PlmnListDescription_CreatenewPLMNList;

	@FindBy(id="plmn.plmnListReference")
	public static WebElement PlmnListReference_CreatenewPLMNList;

	@FindBy(id="submit")
	public static WebElement Save_CreatenewPLMNList;

	@FindBy(name="formSearchValue")
	public static WebElement PLMNListNameSearchBox_ManagePLMNList;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement PLMNListNameSearchIcon_ManagePLMNList;

	@FindBy(id="overviewtable3")
	public static WebElement PLMNTable_ManagePLMNList;
	
	
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement errormessage_ManagePLMNList;

	public static WebDriver driver;

	public GDSP_PlatformGUI_044(WebDriver driver)
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


	public void createPLMNList(String Name, String Description, String  Reference, com.aventstack.extentreports.ExtentTest test,String tcid) throws InterruptedException
	{
		ManagePLMNList_PlatformTab.click();
		Create_ManagePLMNList.click();
		PlmnListName_CreatenewPLMNList.sendKeys(Name);
		PlmnListDescription_CreatenewPLMNList.sendKeys(Description);
		PlmnListReference_CreatenewPLMNList.sendKeys(Reference);
		Save_CreatenewPLMNList.click();
		Thread.sleep(2000);
		try{
			if(errormessage_ManagePLMNList.isDisplayed())
			{
				test.log(Status.INFO, errormessage_ManagePLMNList.getText());
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				System.out.println("PLMN List has not been created because of some internal error");
			}
		}
		catch(Exception e){
			test.log(Status.INFO, "PLMN List has been created");
		}
		
	}

	public void searchPLMNList(String Name, com.aventstack.extentreports.ExtentTest test , String tcid) throws IOException, ClassNotFoundException, SQLException
	{	
		ManagePLMNList_PlatformTab.click();
		PLMNListNameSearchBox_ManagePLMNList.sendKeys(Name);
		PLMNListNameSearchIcon_ManagePLMNList.click();

		if(PLMNTable_ManagePLMNList.getText().contains(Name))
		{
			test.log(Status.PASS, " Search is successful for created PLMN List");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			Database.tc044(Name);
			test.log(Status.INFO, "Db has been verified");
			System.out.println("PLMN List has  been created and searched successfully");
		}
		else
		{
			test.log(Status.FAIL, " Search is not found for created PLMN List");
			String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath5);
		}

	}


}
