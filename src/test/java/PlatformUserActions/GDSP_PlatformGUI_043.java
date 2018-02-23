package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_043 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_opco_overview.htm']")
	public static WebElement ManageOpCos_PlatformTab;

	@FindBy(xpath="//a[@href='manage_lft_overview.htm']")
	public static WebElement LFTConfigurations_ManageLFTConfigurations;

	@FindBy(name="formSearchValue")
	public static WebElement LFTNameSearchBox_ManageLFTConfigurations;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement LFTNameSearchIcon_ManageLFTConfigurations;

	@FindBy(id="overviewtable3")
	public static WebElement LFTTable_ManageLFTConfigurations;

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Edit_ManageLFTConfigurations;

	@FindBy(name="lftConfiguration.lftConfigurationName")
	public static WebElement Name_EditLFTConfiguration;

	@FindBy(name="lftConfiguration.lftSourceRoot")
	public static WebElement SourceRoot_EditLFTConfiguration;

	@FindBy(name="lftConfiguration.lftDestinationRoot")
	public static WebElement DestinationRoot_EditLFTConfiguration;

	@FindBy(id="submit")
	public static WebElement save_EditLFTConfiguration;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_EditLFTConfiguration;

	public static WebDriver driver;

	public GDSP_PlatformGUI_043(WebDriver driver)
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

	public void serachLFTConfiguration(String Name,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException
	{
		ManageOpCos_PlatformTab.click();
		LFTConfigurations_ManageLFTConfigurations.click();
		LFTNameSearchBox_ManageLFTConfigurations.sendKeys(Name);
		LFTNameSearchIcon_ManageLFTConfigurations.click();
		try{
		if(LFTTable_ManageLFTConfigurations.getText().contains(Name))
		{
			test.log(Status.INFO, " Search is successful for LFT Configuration");

		}}
		catch(Exception e1)
		{
			test.log(Status.INFO, " Search is not found for LFT Configuration");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
		}	
	}
	public void editLFTConfiguration(String Name, String SourceRoot, String  DestinationRoot, com.aventstack.extentreports.ExtentTest test,String tcid) throws InterruptedException, IOException, ClassNotFoundException, SQLException
	{
		try{
		if(Edit_ManageLFTConfigurations.isDisplayed())
		{
			Edit_ManageLFTConfigurations.click();
			Name_EditLFTConfiguration.clear();
			Name_EditLFTConfiguration.sendKeys(Name);
			SourceRoot_EditLFTConfiguration.clear();
			SourceRoot_EditLFTConfiguration.sendKeys(SourceRoot);
			DestinationRoot_EditLFTConfiguration.clear();
			DestinationRoot_EditLFTConfiguration.sendKeys(DestinationRoot);
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			test.log(Status.INFO, "edit has been done successfully");
			save_EditLFTConfiguration.click();	

			try{
				if(validationMesaage_EditLFTConfiguration.isDisplayed()){
					if(validationMesaage_EditLFTConfiguration.getText().contains("error"))
					{
						test.log(Status.INFO, validationMesaage_EditLFTConfiguration.getText());
						test.log(Status.FAIL, "Edit has not done successfully");
						String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath2);
					}
				}	

			}
			catch(Exception e1)
			{
				Database.tc043(Name);
				test.log(Status.INFO, "Db has been verified");
				test.log(Status.PASS,"Edit LFT Configuration is successful");
				System.out.println("edit has been done successfully");
				Database.tc043(Name);
				System.out.println("delete has been done successfully");
			}

		}}
		catch(Exception e2)
		{
			test.log(Status.INFO, "edit is not able to perform");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);	
			test.log(Status.FAIL, "EDIT is not successful since EDIT link is not available");
		}
	}
}
