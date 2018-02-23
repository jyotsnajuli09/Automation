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

public class GDSP_PlatformGUI_026 {

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

	@FindBy(xpath="//a[contains(text(),'GHLR Templates')]")
	public static WebElement GHLRTemplates_ManageGHLRTemplates;

	@FindBy(name="formSearchValue")
	public static WebElement TemplateNameSearchBox_ManageGHLRTemplates;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement SearchIcon_ManageGHLRTemplates;

	//a[contains(text(),'Edit')]
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement EditLink_ManageGHLRTemplates;

	@FindBy(name="ghlrTemplate.ghlrTemplateName")
	public static WebElement Name_EditGHLRTemplateDetails;

	@FindBy(name="ghlrTemplate.ghlrTemplateDesc")
	public static WebElement Description_EditGHLRTemplateDetails;

	@FindBy(name="ghlrTemplate.secondaryMsisdnRequired")
	public static WebElement SecondaryMSISDNRequired_EditGHLRTemplateDetails;

	@FindBy(name="networkServiceCheckBox1")
	public static WebElement LTE_EditGHLRTemplateDetails;

	@FindBy(name="networkServiceCheckBox2")
	public static WebElement CSVoice_EditGHLRTemplateDetails;

	@FindBy(name="networkServiceCheckBox3")
	public static WebElement PSData_EditGHLRTemplateDetails;

	@FindBy(name="networkServiceCheckBox4")
	public static WebElement NBIOT_EditGHLRTemplateDetails;

	@FindBy(name="ghlrTemplate.templateFieldList[0]")
	public static WebElement Subscription_EditGHLRTemplateDetails;

	@FindBy(name="ghlrTemplate.templateFieldList[1]")
	public static WebElement CAMELServicesProfile_EditGHLRTemplateDetails;

	@FindBy(name="ghlrTemplate.templateFieldList[2]")
	public static WebElement EPSProfileId_EditGHLRTemplateDetails;

	@FindBy(name="ghlrTemplate.templateFieldList[3]")
	public static WebElement NAM_EditGHLRTemplateDetails;

	@FindBy(xpath="//*[@value='Save']")
	public static WebElement Save_EditGHLRTemplateDetails;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_EditGHLRTemplateDetails;

	@FindBy(xpath="//*[@value='Cancel']")
	public static WebElement Cancel_EditGHLRTemplateDetails;

	public static WebDriver driver;

	public GDSP_PlatformGUI_026(WebDriver driver)
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


	public void editGHLRTemplate(String name, String description, String SecondaryMSISDNRequired,com.aventstack.extentreports.ExtentTest test, String tcid) throws ClassNotFoundException, SQLException, IOException
	{
		ManageSystem_PlatformTab.click();
		GHLRTemplates_ManageGHLRTemplates.click();
		TemplateNameSearchBox_ManageGHLRTemplates.sendKeys(name);
		SearchIcon_ManageGHLRTemplates.click();
		test.log(Status.INFO, "GHLR search is successful");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);	
		try{
			if(EditLink_ManageGHLRTemplates.isDisplayed())
			{
				EditLink_ManageGHLRTemplates.click();
				Name_EditGHLRTemplateDetails.clear();
				Name_EditGHLRTemplateDetails.sendKeys(name);
				Description_EditGHLRTemplateDetails.sendKeys(description);
				Select dropdown2 = new Select(SecondaryMSISDNRequired_EditGHLRTemplateDetails);
				dropdown2.selectByVisibleText(SecondaryMSISDNRequired);
				LTE_EditGHLRTemplateDetails.click();
				CSVoice_EditGHLRTemplateDetails.click();
				PSData_EditGHLRTemplateDetails.click();
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);	
				Save_EditGHLRTemplateDetails.click();

				try{
					if(validationMesaage_EditGHLRTemplateDetails.isDisplayed()){
						if(validationMesaage_EditGHLRTemplateDetails.getText().contains("error"))
						{
							test.log(Status.INFO, validationMesaage_EditGHLRTemplateDetails.getText());
							test.log(Status.FAIL, "GHLR Template Details does not edited successfully");
							String screenShotPath6=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath6);
						}
					}	

				}
				catch(Exception e1)
				{
					String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath4);	
					test.log(Status.INFO, "Edit for given GHLR is successful");
					Database.tc026(name);
					test.log(Status.INFO, "DB has been verified");
					test.log(Status.PASS, "Edit and DB verification has been done for given GHLR");
				}

			}
		}

		catch(Exception e)
		{
			System.out.println("Edit link is not available");
			String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath5);	
			test.log(Status.FAIL, "EDIT is not successful since given BSG is not available");
		}

	}
}
