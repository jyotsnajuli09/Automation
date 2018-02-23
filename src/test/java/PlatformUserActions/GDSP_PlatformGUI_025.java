package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DB.Database;
import genericLibrary.TakeScreenshot;


public class GDSP_PlatformGUI_025 {

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
	
	@FindBy(id="ghlrGroupId")
	public static WebElement GHLRTemplateDropDown_ManageGHLRTemplates;
	
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement CreateButton_ManageGHLRTemplates;
	
	@FindBy(name="ghlrTemplate.ghlrTemplateName")
	public static WebElement Name_CreatenewGHLRTemplate;
	
	@FindBy(name="ghlrTemplate.ghlrTemplateDesc")
	public static WebElement Description_CreatenewGHLRTemplate;
	
	@FindBy(name="ghlrTemplate.secondaryMsisdnRequired")
	public static WebElement SecondaryMSISDNRequired_CreatenewGHLRTemplate;
	
	@FindBy(name="networkServiceCheckBox1")
	public static WebElement LTE_CreatenewGHLRTemplate;
	
	@FindBy(name="networkServiceCheckBox2")
	public static WebElement CSVOICE_CreatenewGHLRTemplate;
	
	@FindBy(name="networkServiceCheckBox3")
	public static WebElement G2G3PSDATA_CreatenewGHLRTemplate;
	
	@FindBy(name="networkServiceCheckBox4")
	public static WebElement NBIOT_CreatenewGHLRTemplate;
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement Save_CreatenewGHLRTemplate;
	
	@FindBy(xpath="//input[@value='Cancel']")
	public static WebElement Cancel_CreatenewGHLRTemplate;
	
	@FindBy(name="formSearchValue")
	public static WebElement TemplateNameSearchBox_ManageGHLRTemplates;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement SearchIcon_ManageGHLRTemplates;
	
	
	@FindBy(xpath="//p[@class='validationmessage']")
	public static WebElement errormessage_CreatenewGHLRTemplate;
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_025(WebDriver driver)
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
	
	public void createGHLRTemplate(com.aventstack.extentreports.ExtentTest test,String tcid,String GHLRTemplate, String name, String SecondaryMSISDNRequired , String description, String ExtraServiceSupported) throws IOException, ClassNotFoundException, SQLException
	  {
		ManageSystem_PlatformTab.click();
		GHLRTemplates_ManageGHLRTemplates.click();
		Select dropdown1 = new Select(GHLRTemplateDropDown_ManageGHLRTemplates);
		//dropdown1.selectByVisibleText(GHLRTemplate);
		dropdown1.selectByIndex(1);
		CreateButton_ManageGHLRTemplates.click();
		Name_CreatenewGHLRTemplate.sendKeys(name);
		Description_CreatenewGHLRTemplate.sendKeys(description);
		Select dropdown2 = new Select(SecondaryMSISDNRequired_CreatenewGHLRTemplate);
		dropdown2.selectByVisibleText(SecondaryMSISDNRequired);	
		LTE_CreatenewGHLRTemplate.click();		
		CSVOICE_CreatenewGHLRTemplate.click();
		G2G3PSDATA_CreatenewGHLRTemplate.click();
		//NBIOT_CreatenewGHLRTemplate.click();
		Save_CreatenewGHLRTemplate.click();
		
		try
		{
			if(errormessage_CreatenewGHLRTemplate.getText().contains("error"))
			{
		    test.log(Status.INFO, errormessage_CreatenewGHLRTemplate.getText());
		    test.log(Status.FAIL, "GHLR Template creation is not done because of above error");
			}
		}
		catch(Exception e)
		{
		test.log(Status.INFO, "GHLRTemplate created/already present");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);	
		Database.tc025(name);
		test.log(Status.INFO, "DB has been verified");
		 test.log(Status.PASS, "GHLR Template creation is succeessful");
		}
	    }
	
	public void searchGHLRTemplate(String name, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException
	 {
		GHLRTemplates_ManageGHLRTemplates.click();
		TemplateNameSearchBox_ManageGHLRTemplates.sendKeys(name);
		SearchIcon_ManageGHLRTemplates.click();
		test.log(Status.INFO, "GHLR search is successful");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);		
	   }
}
