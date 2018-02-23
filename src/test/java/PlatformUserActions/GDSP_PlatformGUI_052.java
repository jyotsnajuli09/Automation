package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_052 {
	
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
	
	@FindBy(xpath="//input[@value='Upload']")
	public static WebElement Upload_ManageSGSNMappings;
	
	@FindBy(name="uploadedMultipartFile.file")
	public static WebElement ChooseFile_UploadSGSNMappingsBatch;
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_052(WebDriver driver)
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
	
	public void uploadFile(com.aventstack.extentreports.ExtentTest test, String tcid, String exeFileLocation) throws IOException
	{
		ManageSystem_PlatformTab.click();
		SGSNMapping_ManageAAAClients.click();
		Upload_ManageSGSNMappings.click();
		test.log(Status.INFO, "Clicking on upload button is success");
		ChooseFile_UploadSGSNMappingsBatch.click();
		Runtime.getRuntime().exec("exeFileLocation");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		test.log(Status.INFO, "File has been uploaded successfully");
		
	}

}
