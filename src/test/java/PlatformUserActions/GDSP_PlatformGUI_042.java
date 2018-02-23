package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_042 {
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
	
	@FindBy(id="submit")
	public static WebElement Create_ManageLFTConfigurations;
	
	@FindBy(name="lftConfiguration.lftConfigurationName")
	public static WebElement Name_CreatenewLFTConfiguration;
	
	@FindBy(name="lftConfiguration.lftSourceRoot")
	public static WebElement SourceRoot_CreatenewLFTConfiguration;
	
	@FindBy(name="lftConfiguration.lftDestinationRoot")
	public static WebElement DestinationRoot_CreatenewLFTConfiguration;
	
	@FindBy(id="submit")
	public static WebElement Save_CreatenewLFTConfiguration;
	
	@FindBy(name="formSearchValue")
	public static WebElement LFTNameSearchBox_ManageLFTConfigurations;
	
	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement LFTNameSearchIcon_ManageLFTConfigurations;
	
	@FindBy(id="overviewtable3")
	public static WebElement LFTTable_ManageLFTConfigurations;
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_createLFTConfiguration;
	
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_042(WebDriver driver)
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

	public void createLFTConfiguration(String Name, String SourceRoot, String  DestinationRoot, com.aventstack.extentreports.ExtentTest test,String tcid) throws InterruptedException, Exception
	{
		ManageOpCos_PlatformTab.click();
		Thread.sleep(3000);
		LFTConfigurations_ManageLFTConfigurations.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
		Create_ManageLFTConfigurations.click();
		Name_CreatenewLFTConfiguration.sendKeys(Name);
		SourceRoot_CreatenewLFTConfiguration.sendKeys(SourceRoot);
		DestinationRoot_CreatenewLFTConfiguration.sendKeys(DestinationRoot);
		Save_CreatenewLFTConfiguration.click();	
		//test.log(Status.INFO, "LFT Configuration has been created successfully");
	
	
	
		
		try
		{
		if(validationMesaage_createLFTConfiguration.isDisplayed())
		{
		if(validationMesaage_createLFTConfiguration.getText().contains("error"))
		{
			test.log(Status.INFO, " Search is not successful for created LFT Configuration because of internal error");
			 String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			 test.addScreenCaptureFromPath(screenShotPath3);
			 //Database.tc042(Name);
			 //test.log(Status.INFO, "Db has been verified");
			System.out.println("LFT configuration has not been created and searched successfully because of internal error"); 
		}
		}
		}
		catch(Exception e)
		{
			LFTConfigurations_ManageLFTConfigurations.click();
		LFTNameSearchBox_ManageLFTConfigurations.sendKeys(Name);
		LFTNameSearchIcon_ManageLFTConfigurations.click();
			if(LFTTable_ManageLFTConfigurations.getText().contains(Name))
			{
			test.log(Status.INFO, " Search is  found for created LFT Configuration");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			 test.addScreenCaptureFromPath(screenShotPath4);
			 System.out.println("LFT configuration has  been created and searched successfully");
			Database.tc042(Name);
		}
		}
	}
}
