package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.TakeScreenshot;



public class GDSP_PlatformGUI_019 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_platform_ops_details.htm']")
	public static WebElement ManageAccount_PlatformTab;

	@FindBy(xpath="//a[@href='manage_bsg_overview.htm']")
	public static WebElement BusinessServiceGroups_ManageBSG;

	@FindBy(name="formSearchValue")
	public static WebElement GroupNameSearchtextBox_ManageBSG;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement searchIcon_ManageBSG;

	// Here in place of test we have to take value from sheet and pass here
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement EditLink_ManageBSG;

	@FindBy(name="businessServiceGroup.businessServiceGroupName")
	public static WebElement Name_EditBSGDetails;

	@FindBy(name="businessServiceGroup.businessServiceGroupDesc")
	public static WebElement Description_EditBSGDetails;

	@FindBy(name="businessServiceGroup.accessClass")
	public static WebElement Class_EditBSGDetails;

	@FindBy(name="businessServiceGroup.businessServiceList2")
	public static WebElement BusinessServicesList_EditBSGDetails;

	@FindBy(id="submit")
	public static WebElement save_EditBSGDetails;

	// Here in place of test we have to take value from sheet and pass here
	@FindBy(xpath="//a[@href='manage_bsg_clone.htm?businessServiceGroupId=163&editPageNumber=1&searchType=businessServiceGroup&searchValue=test']")
	public static WebElement CopyLink_ManageBSG;

	@FindBy(name="businessServiceGroup.businessServiceGroupName")
	public static WebElement Name_CopyBSGDetails;

	@FindBy(name="businessServiceGroup.businessServiceGroupDesc")
	public static WebElement Description_CopyBSGDetails;

	@FindBy(name="businessServiceGroup.accessClass")
	public static WebElement Class_CopyBSGDetails;

	@FindBy(name="businessServiceGroup.businessServiceList2")
	public static WebElement BusinessServicesList_CopyBSGDetails;

	@FindBy(id="submit")
	public static WebElement save_CopyBSGDetails;

	@FindBy(id="overviewtable3")
	public static WebElement BSGTable_ManageBSG;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_ManageBSG;

	public static WebDriver driver;

	public GDSP_PlatformGUI_019(WebDriver driver)
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

	public void searchBSG(String name,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException
	{
		ManageAccount_PlatformTab.click();
		BusinessServiceGroups_ManageBSG.click();
		BusinessServiceGroups_ManageBSG.click();
		GroupNameSearchtextBox_ManageBSG.sendKeys(name);
		searchIcon_ManageBSG.click();		
		test.log(Status.INFO, "BSG search is successful");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);	
	}

	public void editBSG(String name,  String description, String className, com.aventstack.extentreports.ExtentTest test,String tcid, String BS) throws IOException
	{	
		try{
			if(BSGTable_ManageBSG.getText().contains(name))
			{
				test.log(Status.INFO, "BSG search is successful");
				EditLink_ManageBSG.click();	
				Description_EditBSGDetails.clear();
				Description_EditBSGDetails.sendKeys(description);
				save_EditBSGDetails.click();
				try{
					if(validationMesaage_ManageBSG.isDisplayed()){
						if(validationMesaage_ManageBSG.getText().contains("error"))
						{
							test.log(Status.INFO, validationMesaage_ManageBSG.getText());
							test.log(Status.FAIL, "BSG does not edited successfully");
							String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath2);
						}
					}	

				}
				catch(Exception e1)
				{
					test.log(Status.PASS,"Edit BSG is successful");
				}

			}		
		}
		catch(Exception e1)
		{
			test.log(Status.INFO, "BSG search not found");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			test.log(Status.FAIL, "EDIT is not successful since given BSG is not available");
		}

	}



}
