package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_037 {

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

	@FindBy(name="formSearchValue")
	public static WebElement OpCoCodeSeachBox_ManageOpCos;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement OpCoCodeSeachIcon_ManageOpCos;

	@FindBy(id="overviewtable3")
	public static WebElement OpCoTable_ManageOpCos;

	public static WebDriver driver;

	public GDSP_PlatformGUI_037(WebDriver driver)
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



	public void searchOpco(String OpcoCode,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException, ClassNotFoundException, SQLException
	{
		ManageOpCos_PlatformTab.click();
		OpCoCodeSeachBox_ManageOpCos.sendKeys(OpcoCode);
		OpCoCodeSeachIcon_ManageOpCos.click();

		if((OpCoTable_ManageOpCos.getText()).contains(OpcoCode))
		{
			test.log(Status.INFO, "Search for given opco is suceesful");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			System.out.println("Search for given opco is suceesful");
			Database.tc037(OpcoCode);
			test.log(Status.INFO, "DB has been verified");
		}		
		else
		{
			test.log(Status.INFO, "Search for given opco is not found");
			System.out.println("Search RESULT for given opco is not found");
		}
	}

}
